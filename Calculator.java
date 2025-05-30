import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class Calculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            System.out.print("Enter operation (+, -, *, /): ");
            char op = sc.next().charAt(0);

            double result = 0;

            switch (op) {
                case '+': result = a + b; break;
                case '-': result = a - b; break;
                case '*': result = a * b; break;
                case '/':
                    if (b == 0)
                        throw new ArithmeticException("Cannot divide by zero");
                    result = (double) a / b;
                    break;
                default:
                    throw new InvalidInputException("Invalid operation entered.");
            }

            System.out.println("Result: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Invalid number entered.");
        } catch (ArithmeticException e) {
            System.out.println("Math Error: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Input Error: " + e.getMessage());
        } finally {
            System.out.println("Calculator operation completed.");
        }
    }
}
