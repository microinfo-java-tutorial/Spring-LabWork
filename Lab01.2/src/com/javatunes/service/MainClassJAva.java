package com.javatunes.service;

/**
 * Created by smannem on 7/22/2015.
 */
public class MainClassJAva {


    public static void main(String ars[]) {
        String str = "123";
        int finalNumber = 0;
        System.out.println(((int)str.charAt(0)) * 100);
        finalNumber = (((int)str.charAt(0)) * 100) + (((int)str.charAt(1)) * 10) + (((int)str.charAt(2)));
        System.out.println("final number : " + finalNumber);

    }
}
