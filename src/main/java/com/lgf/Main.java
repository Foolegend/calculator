package com.lgf;

public class Main {
    public  static  void main(String[] args){
        Calc calc = new Calc();
//        System.out.println(calc.calc(" 1 + 2"));
//        System.out.println(calc.calc(" 3 * 2"));
//        System.out.println(calc.calc(" 6 / 2"));
//        System.out.println(calc.calc(" 1 - 2"));
//
//        System.out.println(calc.calc(" 1 - 2 + 3"));
        System.out.println(calc.calc(" 1 - 2 + 3 * 4 / 4 * 4"));
        System.out.println(calc.calc(" (1 + (2 + (4+5+1) + 1) - 1)"));
        System.out.println(calc.calc(" (1 + (2 + (4-5+1) + 1) - 1)"));
        System.out.println(calc.calc(" (1 + (2 + (4/5-1) + 1) - 1)"));
        System.out.println(calc.calc(" (1 + (2 + (4*5-1) + 1) - 1)"));


    }
}
