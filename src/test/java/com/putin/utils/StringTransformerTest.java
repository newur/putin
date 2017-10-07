package com.putin.utils;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ruwen on 07.10.17.
 */
public class StringTransformerTest {
    @Test
    public void getURLfromCssValue() throws Exception {
        String firstPart = "url(\"";
        String secondPart = "https://lh3.googleusercontent" +
                ".com/JkChPaPGbhlz4JBb4KXq3rzQY5Kk9KfKeo6LawQohDzPrdt8dQmIpg7Eb_DAUPjByJM486zh-eMpIEF6fuuG-fo" +
                "-cFJ6rrbTBZJjlUAY4hm-MM4EcDEgocGH1Mype" +
                "-AdfIlvSX9nDz9Jl5twO8w2rczrB5evpcKJ4RUHIXstZk98voUDAk94QBOP7RxD4XG2XTFxBe2kWTSuDadwkqS2sP1CXPP1wqo" +
                "Mb8PLsf0Bsf2DAnM7v3haGr2SaHf2jCXWRBhN9fPV7oFeHl8M1i_ljzY_XwWpdY5cQk_iPbze6zaMein5eoY-S1hqifAmV8cex" +
                "HfadBjLRlEUm-7oqWldvPTCVNc-TBiLp--S0FDuAhdBq7qLgbV1Faijlll2VGVnITr47iklETyDOk0CWC_Q3hsRXCXAXxNgtoR" +
                "XSKe7cB4ftJkQuVaF4ko_63btiObsGH2VHCWuvK-Up6jzH9SWJ368nAOVjBtkyY8wL8npZqu6u14v5PpsiP-xWDw_6QhadOXU_" +
                "mC93-jP3p9RLSH3xkH9mFzk1cFVWuIDHTcinkt7InDcbGpyVifdTveeSc-QKzNnw2GitDy5U045OdYORzv1s3guR1rImn8rWlg" +
                "LHw";
        String thirdPart = "=w614-h408-no\")";
        String input = firstPart + secondPart +thirdPart;

        String urLfromCssValue = StringTransformer.getURLfromCssValue(input);
        assertEquals(secondPart, urLfromCssValue);
    }

    @Test
    public void nullTest() throws Exception {
        assertNull(StringTransformer.getURLfromCssValue(null));
    }

    @Test
    public void randomString() throws Exception {
        String input = "jrefervernfkderfekjn3487r34nkdckec";

        String urLfromCssValue = StringTransformer.getURLfromCssValue(input);
        Assertions.assertThat(urLfromCssValue).isNotEmpty();
    }
}