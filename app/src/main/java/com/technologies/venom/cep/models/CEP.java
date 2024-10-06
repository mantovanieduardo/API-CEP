package com.technologies.venom.cep.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CEP {

    @SerializedName("cep")
    @Expose
    private String cep;
    @SerializedName("logradouro")
    @Expose
    private String logradouro;
    @SerializedName("complemento")
    @Expose
    private String complemento;
    @SerializedName("bairro")
    @Expose
    private String bairro;
    @SerializedName("localidade")
    @Expose
    private String localidade;
    @SerializedName("uf")
    @Expose
    private String uf;
    @SerializedName("unidade")
    @Expose
    private String unidade;
    @SerializedName("ibge")
    @Expose
    private String ibge;
    @SerializedName("gia")
    @Expose
    private String gia;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "cep:" + getCep() +
                "\nlogradouro:" + getLogradouro()+
                "\ncomplemento:" + getComplemento()+
                "\nbairro:" + getBairro()+
                "\nlocalidade:"+ getLocalidade()+
                "\nuf" + getUf()+
                "\nunidade:"+ getUnidade()+
                "\nibge:" + getIbge()+
                "\ngia" + getGia();
    }

}