package com.company.PrintTillHundred;

public class printNumber implements Runnable{

    int toPrint;

    printNumber(int toPrint){
        this.toPrint = toPrint;
    }
    @Override
    public void run() {
        System.out.println("Printing "+this.toPrint+". Printed by thread "+ Thread.currentThread().getName());
    }
}
