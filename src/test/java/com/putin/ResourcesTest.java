package com.putin;

import com.putin.utils.GeckoDriverFinder;
import org.junit.Test;

import static org.springframework.util.Assert.notNull;

/**
 * Created by ruwen on 03.10.17.
 */
public class ResourcesTest {

    @Test
    public void geckoDriverFinderTest() {
        String geckoDriverForOS = GeckoDriverFinder.findGeckoDriverForOS();

        notNull(geckoDriverForOS, "geckodriver was not found");
    }
}
