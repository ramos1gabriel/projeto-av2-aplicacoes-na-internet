/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av2.gabriel.sousa.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class Util {
    public static boolean isBlankOrNull(String str) {
        return "".equals(str) || str == null;
    }
}
