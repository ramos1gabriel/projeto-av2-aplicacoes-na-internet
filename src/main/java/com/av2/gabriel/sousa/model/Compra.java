/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av2.gabriel.sousa.model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Gabriel
 */
public class Compra {
    Long id;
    Long idUsuario;
    Long idProduto;
    Date dataCompra;
    Long quantidade;
    Double valorCompra;

    public Compra() {}
    
    public Compra(Long idUsuario, Long idProduto, Date dataCompra, Long quantidade, Double valorCompra) {
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
        this.dataCompra = dataCompra;
        this.quantidade = quantidade;
        this.valorCompra = valorCompra;
    }

    public Compra(Long id, Long idUsuario, Long idProduto, Date dataCompra, Long quantidade, Double valorCompra) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
        this.dataCompra = dataCompra;
        this.quantidade = quantidade;
        this.valorCompra = valorCompra;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }
    
    //Transient
    private String nomeUsuario;
    private String nomeProduto;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    
    //
    public String getProtocolo(){
        LocalDate localDate =  getDataCompra().toLocalDate();
        int ano  = localDate.getYear();
        int mes = localDate.getMonthValue();
        int dia   = localDate.getDayOfMonth();
        String protocolo = "0000000"+ano+""+mes+""+dia+getId();
        return protocolo;
    }
}
