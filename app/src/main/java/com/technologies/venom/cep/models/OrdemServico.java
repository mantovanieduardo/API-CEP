package com.technologies.venom.cep.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrdemServico implements Serializable {

    @SerializedName("os")
    @Expose
    private Integer os;
    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("hora")
    @Expose
    private String hora;
    @SerializedName("tecnico")
    @Expose
    private String tecnico;
    @SerializedName("idCliente")
    @Expose
    private Integer idCliente;
    @SerializedName("cliente")
    @Expose
    private String cliente;
    @SerializedName("contato")
    @Expose
    private String contato;
    @SerializedName("sistema")
    @Expose
    private String sistema;
    @SerializedName("motivo")
    @Expose
    private String motivo;
    @SerializedName("urgencia")
    @Expose
    private Integer urgencia;
    @SerializedName("departamento")
    @Expose
    private String departamento;
    @SerializedName("pendente")
    @Expose
    private String pendente;

    /**
     * No args constructor for use in serialization
     *
     */
    public OrdemServico() {
    }

    /**
     *
     * @param cliente
     * @param motivo
     * @param os
     * @param data
     * @param idCliente
     * @param hora
     * @param sistema
     * @param departamento
     * @param tecnico
     * @param pendente
     * @param contato
     * @param urgencia
     */
    public OrdemServico(Integer os, String data, String hora, String tecnico, Integer idCliente, String cliente, String contato, String sistema, String motivo, Integer urgencia, String departamento, String pendente) {
        super();
        this.os = os;
        this.data = data;
        this.hora = hora;
        this.tecnico = tecnico;
        this.idCliente = idCliente;
        this.cliente = cliente;
        this.contato = contato;
        this.sistema = sistema;
        this.motivo = motivo;
        this.urgencia = urgencia;
        this.departamento = departamento;
        this.pendente = pendente;
    }

    public Integer getOs() {
        return os;
    }

    public void setOs(Integer os) {
        this.os = os;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Integer getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(Integer urgencia) {
        this.urgencia = urgencia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPendente() {
        return pendente;
    }

    public void setPendente(String pendente) {
        this.pendente = pendente;
    }

}
