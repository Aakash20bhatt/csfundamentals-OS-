package com.companyOS.PrintTillHundred;

public class client {

    public static void main(String[] args) {
        for(int i=1; i<=100; i++){
            printNumber pb = new printNumber(i);
            Thread t = new Thread(pb);
            t.start();

        }
    }
}
