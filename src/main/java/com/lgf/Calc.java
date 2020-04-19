package com.lgf;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    List<Integer> nums;
    StringBuilder opers;

    public int calc(String expression){
        if(expression==null || expression.trim().length() == 0){
            throw new IllegalArgumentException("expression is null");
        }
        nums = new ArrayList<Integer>();
        opers = new StringBuilder();
        expression = expression.replaceAll("\\s*", "");
        while(expression.length() > 0){
            char curChar = expression.charAt(0);
            switch (curChar){
                case '(':
                    opers.append(curChar);
                    break;
                case ')':
                    while(opers.length() > 0 && opers.charAt(opers.length() - 1) != '('){
                        nums.add(calculator());
                    }
                    opers.deleteCharAt(opers.length() - 1);
                    break;
                case '+':
                    addOrSub(curChar);
                    break;
                case '-':
                    addOrSub(curChar);
                    break;
                case '*':
                    mulOrDiv(curChar);
                    break;
                case '/':
                    mulOrDiv(curChar);
                    break;
                default:
                    nums.add(curChar - 48);

            }
            expression = expression.substring(1);
        }
        while(opers.length() > 0){
            nums.add(calculator());
        }
        return nums.get(0);
    }

    private void mulOrDiv(char curChar) {
        if (nums.size() >= 2 && opers.length() > 0 && (opers.charAt(opers.length() - 1) == '*' || opers.charAt(opers.length() - 1) == '/')) {
            nums.add(calculator());
        }
        opers.append(curChar);
    }

    private void addOrSub(char curChar) {
        if (nums.size() >= 2 && opers.length() > 0 && (opers.charAt(opers.length() - 1) == '*' || opers.charAt(opers.length() - 1) == '/' || opers.charAt(opers.length() - 1) == '-' || opers.charAt(opers.length() - 1) == '+')) {
            nums.add(calculator());
        }
        opers.append(curChar);
    }

    private int calculator(){
        int rightNum = nums.remove(nums.size() - 1);
        int leftNum = nums.remove(nums.size() - 1);
        char curChar = opers.charAt(opers.length() - 1);
        opers.deleteCharAt(opers.length() - 1);
        switch (curChar){
            case '+':
                return leftNum + rightNum;
            case '-':
                return leftNum - rightNum;
            case '*':
                return leftNum * rightNum;
            case '/':
                return leftNum/rightNum;
            default:
                return 0;
        }
    }
}
