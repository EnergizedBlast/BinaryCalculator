package main.model;

public class BinaryCalculator {
    public String maxString = "";
    public String minString = "";
    public StringBuilder sb = new StringBuilder();

    public String add(String s1, String s2) {
        if (s1.length() > s2.length()) {
            maxString = s1;
            minString = s2;
        } else {
            maxString = s2;
            minString = s1;
        }

        int temp = 0;
        int sum;
        int index1, index2;
        int num1, num2;

        for (int i = 1; i <= minString.length(); i++) {
            index1 = maxString.length() - i;
            index2 = minString.length() - i;
            num1 = getNum(maxString, index1);
            num2 = getNum(minString, index2);
            sum = num1 + num2 + temp;
            temp = checkSum(sum, temp);
        }

        int differenceBetweenLengths = maxString.length() - minString.length();
        if (differenceBetweenLengths > 0) {
            for (int i = 1; i <= differenceBetweenLengths; i++) {
                index1 = differenceBetweenLengths - i;
                num1 = getNum(maxString, index1);
                sum = num1 + temp;
                temp = checkSum(sum, temp);
            }
        }
        if (temp == 1) {
            sb.insert(0, temp);
        }

        return sb.toString();
    }

    private int getNum(String str, int index) {
        char c = str.charAt(index);
        return Character.getNumericValue(c);
    }

    private int checkSum(int sum, int temp) {
        switch (sum) {
            case 1: sb.insert(0, 1);
                temp = 0;
                break;
            case 2: sb.insert(0, 0);
                temp = 1;
                break;
            case 3: sb.insert(0, 1);
                temp = 1;
                break;
            default: sb.insert(0, 0);
        }
        return temp;
    }
}