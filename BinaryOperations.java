package com.vedansh.binaryoperations;

public class BinaryOperations {

    public String add(String num1, String num2) {
        double n1 = binaryToDecimal(num1);
        double n2 = binaryToDecimal(num2);
        double sum = n1 + n2;
        return decimalToBinary(sum);
    }

    public String[] subtract(String num1, String num2) {
        double n1 = binaryToDecimal(num1);
        double n2 = binaryToDecimal(num2);
        double subtraction = n1 - n2;
        if(subtraction >= 0)
            return new String[] {decimalToBinary(subtraction), ""};
        subtraction = Math.abs(subtraction);
        return new String[] {("-"+decimalToBinary(subtraction)),twosComplement(decimalToBinary(subtraction))};
    }

    public String multiply(String num1, String num2) {
        double n1 = binaryToDecimal(num1);
        double n2 = binaryToDecimal(num2);
        double product = n1 * n2;
        return decimalToBinary(product);
    }

    public String divideFraction(String num1, String num2) {
        double n1 = binaryToDecimal(num1);
        double n2 = binaryToDecimal(num2);
        double division = n1/n2;
        return decimalToBinary(division);
    }

    public String[] divide(String num1, String num2) {
        double n1 = binaryToDecimal(num1);
        double n2 = binaryToDecimal(num2);
        double quotient = (long)(n1/n2);
        double remainder = n1%n2;
        return new String[] {decimalToBinary(quotient),decimalToBinary(remainder)};
    }

    public String twosComplement(String num) {
        int decimal = num.indexOf('.');
        String whole, fraction = "";
        if(decimal != -1) {
            whole = num.substring(0,num.indexOf('.'));
            fraction = num.substring(num.indexOf('.')+1);
        }
        else
            whole = num;

        String twosComplement = "";
        for(int i = 0; i < whole.lastIndexOf('1'); i++)
            twosComplement += (whole.charAt(i) == '1')? "0" : "1";

        for(int i = whole.lastIndexOf('1'); i < whole.length(); i++)
            twosComplement += (whole.charAt(i) == '1')? "1" : "0";

        if(decimal != -1) {
            twosComplement += ".";
            for(int i = 0; i < fraction.length(); i++)
                twosComplement += (fraction.charAt(i) == '1')? "0" : "1";
        }
        return twosComplement;
    }

    public double binaryToDecimal(String num) {
        int decimal = num.indexOf('.');
        String whole, fraction = "";
        if(decimal != -1) {
            whole = num.substring(0,num.indexOf('.'));
            fraction = num.substring(num.indexOf('.')+1);
        }
        else
            whole = num;

        int len = whole.length();
        double number = 0;
        for(int i = 0; i < len; i++) {
            if(whole.charAt(len-1-i) == '1')
                number += Math.pow(2,i);
        }
        for(int i = 0; i < fraction.length(); i++) {
            if(fraction.charAt(i) == '1')
                number += Math.pow(2,-1*(i+1));
        }
        return number;
    }

    public String decimalToBinary(double num) {
        if(num == 0)
            return "0";
        long whole = (long)num;
        double fraction = num - whole;
        String number = "";
        while(whole > 0) {
            number = ((whole % 2 == 0)?"0":"1") + number ;
            whole /= 2;
        }
        if(fraction != 0) {
            number += (number.length() == 0)? "0." : ".";
            while(fraction != 0 && number.length() - number.indexOf('.') < 10) {
                fraction *= 2;
                if(fraction >= 1) {
                    fraction -= 1;
                    number += "1";
                }
                else
                    number += "0";
            }
        }

        return number;
    }
}