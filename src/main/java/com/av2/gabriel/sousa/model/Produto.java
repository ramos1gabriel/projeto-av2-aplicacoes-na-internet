/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av2.gabriel.sousa.model;

import java.io.Serializable;

/**
 *
 * @author Gabriel
 */
public class Produto implements Serializable {
    private Long id;
    private String nome;
    private Double preco;
    private String descricao;
    private String url;

    public Produto() {}
    
    public Produto(String nome, Double preco, String descricao, String url) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.url = url;
    }

    public Produto(Long id, String nome, Double preco, String descricao, String url) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
