package com.pm;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)

public class MatchTest {
    private Mezo m1,m2;
    private Tabla t = new Tabla();

    public MatchTest(Mezo a, Mezo b) {m1 = a; m2= b;}

    //tesztelésképpen egy létező meccs lejátszatása
    //forrás: http://www.xqinenglish.com/db2016030720160311.html

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Mezo(7,2), new Mezo(4,2)},
                {new Mezo(7,0), new Mezo(6,2)},
                {new Mezo(1,0), new Mezo(2,2)},
                {new Mezo(6,3), new Mezo(6,4)},
                {new Mezo(1,2), new Mezo(1,6)}
        });
    }

    @Before
    public void setUp() {
        t = new Tabla();
        t.init();
    }

    @Test
    public void lepes() {
        assertTrue("lepes",t.getBabu(m1).getTipus().lephet(m1,m2,t.getBabu(m2),t));
    }
}
