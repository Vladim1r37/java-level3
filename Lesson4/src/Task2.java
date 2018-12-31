import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.*;

public class Task2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")))) {
            service.submit(() -> writeToFile("line printed by thread1", out));
            service.submit(() -> writeToFile("line printed by thread2", out));
            service.submit(() -> writeToFile("line printed by thread3", out));
            Thread.sleep(1000);
        }
        service.shutdown();
    }

    private static void writeToFile(String textLine, PrintWriter out) {
        try {
            for (int i = 0; i < 10; i++) {
                out.println(textLine);
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

