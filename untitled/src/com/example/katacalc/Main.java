package com.example.katacalc;

class Main{
    public static String calc(String input){
        boolean romanOrArab = false;
        String exception = "Исключение. Ошибка. Ввод от 1 до 10";
        int result;
        String[] inputSplit = input.split(" ");
        if (inputSplit.length !=3){
            return exception;
        }
        Integer x; Integer y;
        try {
            x = Integer.valueOf(inputSplit[0]); y = Integer.valueOf(inputSplit[2]);
        } catch (NumberFormatException e) {
            try {
                x = romanToArab(inputSplit[0]); y = romanToArab(inputSplit[2]);
                romanOrArab = true;
            } catch (NumberFormatException ex) {
                return exception;
            }
        }
        if ((x < 1) || (x > 10) || (y < 1) || (y > 10)){
            return exception;
}
        String sign = inputSplit[1];
        switch (sign) {
            case "+" -> result = x + y; case "-" -> result = x - y; case "*" -> result = x * y; case "/" -> result = x / y;
            default -> {
                return exception;
            }
        }
        String output;
        if (romanOrArab){
            if(result < 1){
                return exception;
            } else {
                output = arabToRome(result);
            }
        } else {
            output = Integer.toString(result);
        }
        return output;
    }
    static Integer romanToArab(String romanInput){
        int result = 0;
        int[] arab = {10, 9, 5, 4, 1};
        String[] roman = {"X", "IX", "V", "IV", "I"};
        for (int i = 0; i < arab.length; i++) {
            while (romanInput.indexOf(roman[i]) == 0) {
                result += arab[i];
                romanInput = romanInput.substring(roman[i].length());
            }
        }
        return result;
    }
    static String arabToRome(int arabInput){
        String result = " ";
        int value;
        int[] arab = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"C","XC","L","XL","X","IX","V","IV","I"};
        for (int i = 0; i < arab.length; i++){
            value = arabInput / arab[i];
            for (int j = 0; j < value; j++){
                result = result.concat(roman[i]);
            }
            arabInput = arabInput % arab[i];
        }
        return result;
    }
}