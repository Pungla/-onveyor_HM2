package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Tests")
class CalculatorTest {
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    @DisplayName("Test addition of two numbers")
    void testAddition() {
        assertEquals(5.0, calculator.add(2.0, 3.0), 0.001);
        assertEquals(-1.0, calculator.add(2.0, -3.0), 0.001);
        assertEquals(0.0, calculator.add(0.0, 0.0), 0.001);
    }
    
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
        "2.0, 3.0, 5.0",
        "-2.0, 3.0, 1.0",
        "0.0, 0.0, 0.0",
        "5.5, 4.5, 10.0"
    })
    @DisplayName("Parameterized addition tests")
    void testAdditionParameterized(double a, double b, double expected) {
        assertEquals(expected, calculator.add(a, b), 0.001);
    }
    
    @Test
    @DisplayName("Test subtraction of two numbers")
    void testSubtraction() {
        assertEquals(1.0, calculator.subtract(3.0, 2.0), 0.001);
        assertEquals(5.0, calculator.subtract(2.0, -3.0), 0.001);
        assertEquals(0.0, calculator.subtract(0.0, 0.0), 0.001);
    }
    
    @Test
    @DisplayName("Test multiplication of two numbers")
    void testMultiplication() {
        assertEquals(6.0, calculator.multiply(2.0, 3.0), 0.001);
        assertEquals(-6.0, calculator.multiply(2.0, -3.0), 0.001);
        assertEquals(0.0, calculator.multiply(0.0, 5.0), 0.001);
    }
    
    @Test
    @DisplayName("Test division of two numbers")
    void testDivision() {
        assertEquals(2.0, calculator.divide(6.0, 3.0), 0.001);
        assertEquals(-2.0, calculator.divide(6.0, -3.0), 0.001);
        assertEquals(0.5, calculator.divide(1.0, 2.0), 0.001);
    }
    
    @Test
    @DisplayName("Test division by zero throws exception")
    void testDivisionByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, 
            () -> calculator.divide(5.0, 0.0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
    
    @Test
    @DisplayName("Test power calculation")
    void testPower() {
        assertEquals(8.0, calculator.power(2.0, 3.0), 0.001);
        assertEquals(1.0, calculator.power(5.0, 0.0), 0.001);
        assertEquals(0.25, calculator.power(2.0, -2.0), 0.001);
    }
    
    @Test
    @DisplayName("Test square root calculation")
    void testSquareRoot() {
        assertEquals(2.0, calculator.sqrt(4.0), 0.001);
        assertEquals(3.0, calculator.sqrt(9.0), 0.001);
        assertEquals(0.0, calculator.sqrt(0.0), 0.001);
    }
    
    @Test
    @DisplayName("Test square root of negative number throws exception")
    void testSquareRootNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> calculator.sqrt(-1.0));
        assertEquals("Cannot calculate square root of negative number", exception.getMessage());
    }
    
    @Test
    @DisplayName("Test factorial calculation")
    void testFactorial() {
        assertEquals(1, calculator.factorial(0));
        assertEquals(1, calculator.factorial(1));
        assertEquals(2, calculator.factorial(2));
        assertEquals(6, calculator.factorial(3));
        assertEquals(24, calculator.factorial(4));
        assertEquals(120, calculator.factorial(5));
    }
    
    @ParameterizedTest(name = "factorial({0}) = {1}")
    @CsvSource({
        "0, 1",
        "1, 1",
        "5, 120",
        "10, 3628800",
        "20, 2432902008176640000"
    })
    @DisplayName("Parameterized factorial tests")
    void testFactorialParameterized(int n, long expected) {
        assertEquals(expected, calculator.factorial(n));
    }
    
    @Test
    @DisplayName("Test factorial of negative number throws exception")
    void testFactorialNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> calculator.factorial(-5));
        assertEquals("Factorial is not defined for negative numbers", exception.getMessage());
    }
    
    @Test
    @DisplayName("Test factorial too large throws exception")
    void testFactorialTooLarge() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> calculator.factorial(21));
        assertEquals("Factorial too large for long type (n > 20)", exception.getMessage());
    }
    
    @Test
    @DisplayName("Test modulus calculation")
    void testModulus() {
        assertEquals(1.0, calculator.modulus(5.0, 2.0), 0.001);
        assertEquals(0.0, calculator.modulus(10.0, 5.0), 0.001);
        assertEquals(2.0, calculator.modulus(17.0, 3.0), 0.001);
    }
    
    @Test
    @DisplayName("Test modulus by zero throws exception")
    void testModulusByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class,
            () -> calculator.modulus(5.0, 0.0));
        assertEquals("Modulus by zero is not allowed", exception.getMessage());
    }
    
    @Test
    @DisplayName("Test comprehensive calculation chain")
    void testComprehensiveCalculation() {
        // (2 + 3) * 4 - 10 / 2
        double step1 = calculator.add(2, 3);    // 5
        double step2 = calculator.multiply(step1, 4);  // 20
        double step3 = calculator.divide(10, 2);       // 5
        double result = calculator.subtract(step2, step3); // 15
        
        assertEquals(15.0, result, 0.001);
    }
}