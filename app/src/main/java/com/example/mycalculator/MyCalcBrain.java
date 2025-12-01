package com.example.mycalculator;

import java.util.Scanner;

public class MyCalcBrain {
       private double result;//encapsulation

       public double add(double op1, double op2) {
        result = op1 + op2;
        System.out.println("Add: " + result);
        return result;
    }

    public double subtract(double op1, double op2) {
        result = op1 - op2;
        System.out.println("Sub: " + result);
        return result;
    }

    public double multiply(double op1, double op2) {
        result = op1 * op2;
        System.out.println("Mul: " + result);
        return result;
    }

    public double divide(double op1, double op2) {
        if (op2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        result = op1 / op2;
        System.out.println("Divide: " + result);
        return result;
    }


    public static void main(String[] args) {
        MyCalcBrain calculator = new MyCalcBrain();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number");
        double op1 = input.nextDouble();

        System.out.println("Enter second number");
        double op2 = input.nextDouble();

        calculator.add(op1, op2);
        calculator.subtract(op1, op2);
        calculator.multiply(op1, op2);
        calculator.divide(op1, op2);
        input.close();//Scanner closed
    }

}
