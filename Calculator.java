package com.example;

/**
 * Простой калькулятор с базовыми арифметическими операциями
 */
public class Calculator {
    
    /**
     * Сложение двух чисел
     */
    public double add(double a, double b) {
        return a + b;
    }
    
    /**
     * Вычитание двух чисел
     */
    public double subtract(double a, double b) {
        return a - b;
    }
    
    /**
     * Умножение двух чисел
     */
    public double multiply(double a, double b) {
        return a * b;
    }
    
    /**
     * Деление двух чисел
     * @throws ArithmeticException при делении на ноль
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
    
    /**
     * Возведение в степень
     */
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    /**
     * Вычисление квадратного корня
     * @throws IllegalArgumentException для отрицательных чисел
     */
    public double sqrt(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(number);
    }
    
    /**
     * Вычисление факториала
     * @throws IllegalArgumentException для отрицательных чисел
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Factorial too large for long type (n > 20)");
        }
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Вычисление остатка от деления
     */
    public double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Modulus by zero is not allowed");
        }
        return a % b;
    }
}