/*
 * project ：JunjieFinance
 * author : dluobida
 * class : ExampleInstrumentedTest.java
 * package : com.dluobida.junjiefinance.ExampleInstrumentedTest
 * currentModifyTime : 2019-10-29 21:10:48
 * lastModifyTime : 2019-10-28 23:10:47
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.dluobida.junjiefinance", appContext.getPackageName());
    }
}
