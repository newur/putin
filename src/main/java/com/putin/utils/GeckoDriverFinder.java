package com.putin.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import java.net.URL;
import java.util.Optional;

/**
 * Created by ruwen on 03.10.17.
 */
public class GeckoDriverFinder {

    public static String findGeckoDriverForOS() {
        return Optional.ofNullable(GeckoDriverFinder.class.getResource("/geckodriver"))
                .map(URL::getPath)
                .map(path -> path + OSspecificSuffix())
                .orElse(null);
    }

    private static String OSspecificSuffix() {
        if (SystemUtils.IS_OS_WINDOWS) {
            return ".exe";
        }

        // TODO differentiate between x86 linux and ARM linux (for raspberry)

        return StringUtils.EMPTY;
    }
}
