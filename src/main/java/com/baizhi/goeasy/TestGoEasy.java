package com.baizhi.goeasy;

import io.goeasy.GoEasy;

public class TestGoEasy {

    public static void main(String[] args) {

        GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io","BC-8337111ed1794dada1c2051b702a2ac4");
        goEasy.publish("154_channel","Hello, GoEasy!");

    }



}
