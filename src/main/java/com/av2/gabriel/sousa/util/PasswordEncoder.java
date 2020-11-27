/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av2.gabriel.sousa.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class PasswordEncoder {
    
    private static final String CRYPTO = "MD5"; //SHA-1 //SHA-256
    
    public static String encode(String password) {
        String pass = "";
        try {
            if(!Util.isBlankOrNull(password)) {
                MessageDigest md = MessageDigest.getInstance(CRYPTO);
                md.update(password.getBytes(), 0, password.length());
                pass = new BigInteger(1, md.digest()).toString(16);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordEncoder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pass;
    }
    
   /*TESTE
    public static void main(String args[]) throws Exception{
       String s="123456";
       MessageDigest m=MessageDigest.getInstance("MD5");
       m.update(s.getBytes(),0,s.length());
       System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
    }*/
}
