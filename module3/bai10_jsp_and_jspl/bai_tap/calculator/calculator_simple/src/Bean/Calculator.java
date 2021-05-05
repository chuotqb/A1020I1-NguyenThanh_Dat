package Bean;

public class Calculator {
    public static float  calculate(float numberOne, float numberTwo, char choose) {
        switch (choose) {
            case '+':
                return numberOne+numberTwo;
            case '-':
                return numberOne-numberTwo;
            case '*':
                return numberOne*numberTwo;
            case '/':
                if (numberTwo != 0)
                return numberOne/numberTwo;
                else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
