/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av2.gabriel.sousa.model;

import java.util.Objects;

/**
 *
 * @author Gabriel
 */
public class Usuario {
    
    private Long id;
    private String nome;
    private String username;
    private String senha;
    private String tipo;

    public Usuario() {}
    
    public Usuario(String nome, String username, String senha) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
    }
    
    public Usuario(Long id, String nome, String username, String tipo) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.tipo = tipo;
    }
    
    public Usuario(Long id, String nome, String username, String senha, String tipo) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.tipo = tipo;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario usuario = (Usuario) obj;
        return this.username.equals(usuario.username);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.username);
        return hash;
    }
}
