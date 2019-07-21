package com.baizhi;

import io.goeasy.GoEasy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Cmfz1ApplicationTests {

    @Test
    public void contextLoads() {

        GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io","BC-8337111ed1794dada1c2051b702a2ac4");
        goEasy.publish("154_channel","Hello, GoEasy!");


    }




}
