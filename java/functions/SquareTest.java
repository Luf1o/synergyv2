package functions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SquareTest {
    private int number;

    public SquareTest(int number) {
        this.number = number;
    }

    public void connect() {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "../py-messenger/functions/Haunt.py",
                    String.valueOf(number));
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            System.out.println("Square: ");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
