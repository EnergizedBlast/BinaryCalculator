package main.model;

public class BinaryCalculator {

    public String add(String s1, String s2){
        int decimal1 = Integer.parseInt(s1,2);
        int decimal2 = Integer.parseInt(s2,2);
        int answer = decimal1+decimal2;
        return Integer.toBinaryString(answer);
    }

    public String subtract(String s1, String s2){
        int decimal1 = Integer.parseInt(s1,2);
        int decimal2 = Integer.parseInt(s2,2);
        int answer = decimal1-decimal2;
        return Integer.toBinaryString(answer);
    }

    public String multiply(String s1, String s2){
        int decimal1 = Integer.parseInt(s1,2);
        int decimal2 = Integer.parseInt(s2,2);
        int answer = decimal1*decimal2;
        return Integer.toBinaryString(answer);
    }
    public String divide(String s1, String s2){
        int decimal1 = Integer.parseInt(s1,2);
        int decimal2 = Integer.parseInt(s2,2);
        int answer = decimal1/decimal2;
        return Integer.toBinaryString(answer);
    }
}