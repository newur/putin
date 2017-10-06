package com.putin.calendarservice;

import org.junit.Test;

public class CodeVerifierTest {

    @Test
    public void generateCodeVerifier(){
        String regex = "[A-Za-z_~.-]{43,128}";
        assert CodeVerifier.generateCodeVerifier().matches(regex);
    }

}
