package functions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MultiFnc {
    private int number1, number2;
    private String operation;

    public MultiFnc(int number1, int number2, String operation) {
        this.operation = operation;
        this.number1 = number1;
        this.number2 = number2;
    }

    public void connect() {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "../py-messenger/functions/multiFunctioned.py", operation,
                    String.valueOf(number1),
                    String.valueOf(number2));
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            System.out.println("MultiFnc Result: mode " + operation + " " + number1 + " " + number2);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
