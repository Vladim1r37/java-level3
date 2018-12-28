import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task2 {
    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")))) {
            Future f1 = service.submit(() -> writeToFile("line printed by thread1", out));
            Future f2 = service.submit(() -> writeToFile("line printed by thread2", out));
            Future f3 = service.submit(() -> writeToFile("line printed by thread3", out));
            while (true) {
                try {
                    if (f1.get() == null && f2.get() == null && f3.get() == null) {
                        break;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
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

