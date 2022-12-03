package com.example.katacalc;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите : num1 (пробел) операция (пробел) num2 - Enter");
        String expression = input.nextLine();
        String answer = Main.calc(expression);
        System.out.println("Результат:\n" + answer);
    }
}