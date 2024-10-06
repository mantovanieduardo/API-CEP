package com.technologies.venom.cep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.technologies.venom.cep.R;
import com.technologies.venom.cep.api.RESTService;
import com.technologies.venom.cep.models.CEP;
import com.technologies.venom.cep.models.OrdemServico;
import com.technologies.venom.cep.utils.Mascara;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String URL = "https://viacep.com.br/ws/";

    private Retrofit retrofitCEP;
    private Button btnConsultarCEP;
    private TextInputEditText txtCEP, txtLogradouro, txtComplemento, txtBairro, txtUF, txtLocalidade;
    private TextInputLayout layCEP;
    private ProgressBar progressBarCEP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layCEP = findViewById(R.id.txtinplayCEP);
        txtCEP = findViewById(R.id.txtinpedtCEP);
        txtLogradouro = findViewById(R.id.txtinpedtLogradouro);
        txtComplemento = findViewById(R.id.txtinpedtComplemento);
        txtBairro = findViewById(R.id.txtinpedtBairro);
        txtUF = findViewById(R.id.txtinpedtUF);
        txtLocalidade = findViewById(R.id.txtinpedtLocalidade);
        btnConsultarCEP = findViewById(R.id.btnConsultarCEP);
        progressBarCEP = findViewById(R.id.progressBarCEP);

        //configurando como invisível
        progressBarCEP.setVisibility(View.GONE);

        //Aplicando a máscara para CEP
        txtCEP.addTextChangedListener(Mascara.insert(Mascara.MASCARA_CEP, txtCEP));

        //configura os recursos do retrofit
        retrofitCEP = new Retrofit.Builder()
                .baseUrl(URL)                                       //endereço do webservice
                .addConverterFactory(GsonConverterFactory.create()) //conversor
                .build();

        btnConsultarCEP.setOnClickListener(this);
    }

    private Boolean validarCampos() {

        Boolean status = true;
        String cep = txtCEP.getText().toString().trim();

        if (cep.isEmpty()) {
            txtCEP.setError("Digite um CEP válido.");
            status = false;
        }

        if ((cep.length() > 1) && (cep.length() < 10)) {
            txtCEP.setError("O CEP deve possuir 8 dígitos");
            status = false;
        }
        return status;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConsultarCEP:
                if (validarCampos()) {
                    esconderTeclado();
                    consultarCEP();
                }
                break;
        }
    }

    private void esconderTeclado() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void consultarCEP() {
        String sCep = txtCEP.getText().toString().trim();

        //removendo o ponto e o traço do padrão CEP
        sCep = sCep.replaceAll("[.-]+", "");

        //instanciando a interface
        RESTService restService = retrofitCEP.create(RESTService.class);

        //passando os dados para consulta
        Call<CEP> call = restService.consultarCEP(sCep);

        //exibindo a progressbar
        progressBarCEP.setVisibility(View.VISIBLE);

        //colocando a requisição na fila para execução
        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if (response.isSuccessful()) {
                    CEP cep = response.body();
                    txtLogradouro.setText(cep.getLogradouro());
                    txtComplemento.setText(cep.getComplemento());
                    txtBairro.setText(cep.getBairro());
                    txtUF.setText(cep.getUf());
                    txtLocalidade.setText(cep.getLocalidade());
                    Toast.makeText(getApplicationContext(), "CEP consultado com sucesso", Toast.LENGTH_LONG).show();

                    //escondendo a progressbar
                    progressBarCEP.setVisibility(View.GONE);

                    //TODO desabilitar escrita nos campos com preenchimento automático
                }
            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocorreu um erro ao tentar consultar o CEP. Erro: " + t.getMessage(), Toast.LENGTH_LONG).show();

                //escondendo a progressbar
                progressBarCEP.setVisibility(View.GONE);
            }
        });
    }
}
