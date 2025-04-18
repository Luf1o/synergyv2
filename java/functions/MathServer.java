package functions;

public class MathServer {
    public static void main(String[] args) {
        // System.out.println("MathServer is running..."); Causes the program to stop
        // running , reason: response is given to the client before the operation is
        // done
        if (args.length != 2) {
            System.out.println("Usage: java MathServer <port> <host>");
            return;
        }
        String opertionMode = args[0];
        double number = Double.parseDouble(args[1]);
        switch (opertionMode) {
            case "Square":
                System.out.println("Square of " + number + " is: " + Square(number));
                break;
            case "SquareRoot":
                System.out.println("Square root of " + number + " is: " + SquareRoot((int) number));
                break;
            default:
                System.err.println("not Implemented / not supported operation: " + opertionMode);
                break;
        }
    }

    public static double Square(double number) {
        return number * number;
    }

    public static float SquareRoot(int number) {
        return (float) Math.sqrt(number);
    }

}