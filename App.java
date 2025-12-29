package com.example;

import java.util.Scanner;

/**
 * Основной класс приложения с консольным интерфейсом
 */
public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Simple Java Calculator ===");
        System.out.println("Available operations:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Power (^)");
        System.out.println("6. Square Root (√)");
        System.out.println("7. Factorial (!)");
        System.out.println("8. Modulus (%)");
        System.out.println("0. Exit");
        
        while (true) {
            System.out.print("\nSelect operation (0-8): ");
            int choice;
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }
            
            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }
            
            try {
                switch (choice) {
                    case 1: // Addition
                        System.out.print("Enter first number: ");
                        double a1 = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter second number: ");
                        double b1 = Double.parseDouble(scanner.nextLine());
                        System.out.printf("Result: %.2f + %.2f = %.2f%n", a1, b1, calculator.add(a1, b1));
                        break;
                        
                    case 2: // Subtraction
                        System.out.print("Enter first number: ");
                        double a2 = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter second number: ");
                        double b2 = Double.parseDouble(scanner.nextLine());
                        System.out.printf("Result: %.2f - %.2f = %.2f%n", a2, b2, calculator.subtract(a2, b2));
                        break;
                        
                    case 3: // Multiplication
                        System.out.print("Enter first number: ");
                        double a3 = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter second number: ");
                        double b3 = Double.parseDouble(scanner.nextLine());
                        System.out.printf("Result: %.2f * %.2f = %.2f%n", a3, b3, calculator.multiply(a3, b3));
                        break;
                        
                    case 4: // Division
                        System.out.print("Enter dividend: ");
                        double a4 = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter divisor: ");
                        double b4 = Double.parseDouble(scanner.nextLine());
                        System.out.printf("Result: %.2f / %.2f = %.2f%n", a4, b4, calculator.divide(a4, b4));
                        break;
                        
                    case 5: // Power
                        System.out.print("Enter base: ");
                        double base = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter exponent: ");
                        double exponent = Double.parseDouble(scanner.nextLine());
                        System.out.printf("Result: %.2f ^ %.2f = %.2f%n", base, exponent, calculator.power(base, exponent));
                        break;
                        
                    case 6: // Square Root
                        System.out.print("Enter number: ");
                        double num = Double.parseDouble(scanner.nextLine());
                        System.out.printf("Result: √%.2f = %.2f%n", num, calculator.sqrt(num));
                        break;
                        
                    case 7: // Factorial
                        System.out.print("Enter integer (0-20): ");
                        int n = Integer.parseInt(scanner.nextLine());
                        System.out.printf("Result: %d! = %d%n", n, calculator.factorial(n));
                        break;
                        
                    case 8: // Modulus
                        System.out.print("Enter first number: ");
                        double a8 = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter second number: ");
                        double b8 = Double.parseDouble(scanner.nextLine());
                        System.out.printf("Result: %.2f %% %.2f = %.2f%n", a8, b8, calculator.modulus(a8, b8));
                        break;
                        
                    default:
                        System.out.println("Invalid choice! Please select 0-8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format!");
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}