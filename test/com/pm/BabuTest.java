package com.pm;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BabuTest {

    private Tabla t = new Tabla();

    @Before
    public void setUp() {
        t = new Tabla();
        t.init();
    }


    @Test
    public void GyalogHibasLepesTest() {
        assertTrue("gyalog lépés",!t.getBabu(6,3).getTipus().lephet(new Mezo(6,3),new Mezo(5,3),new Babu(),t));
    }

    @Test
    public void GyalogTest() {
        assertTrue("gyalog lépés",t.getBabu(6,3).getTipus().lephet(new Mezo(6,3),new Mezo(6,4),new Babu(),t));
    }

    @Ignore
    public void TestorTest() {
        assertTrue("gyalog lépés",t.getBabu(6,3).getTipus().lephet(new Mezo(6,3),new Mezo(6,4),new Babu(),t));
    }
}