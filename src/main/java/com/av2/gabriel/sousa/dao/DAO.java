/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av2.gabriel.sousa.dao;

import java.util.List;

/**
 *
 * @author Gabriel
 * @param <T>
 */
public interface DAO<T> {
    T findbyId(Long id);
    void create(T objeto);
    T update(T objeto);
    void remove(Long id);
    List<T> findAll();
}
