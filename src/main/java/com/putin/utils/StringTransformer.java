package com.putin.utils;

import java.util.Optional;

/**
 * Created by ruwen on 07.10.17.
 */
public class StringTransformer {

    public static String getURLfromCssValue(String cssValue) {
        return Optional.ofNullable(cssValue)
                .map(s -> s.substring(5))
                .map(s -> s.split("="))
                .map(array -> array[0])
                .orElse(cssValue);
    }
}
