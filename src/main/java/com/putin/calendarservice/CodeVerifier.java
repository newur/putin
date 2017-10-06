package com.putin.calendarservice;

import nl.flotsam.xeger.Xeger;

public class CodeVerifier {

    public static String generateCodeVerifier(){
        String regex = "[A-Za-z_~.-]{43,128}";
        Xeger generator = new Xeger(regex);
        return generator.generate();
    }

}
