import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Random;

public class Main3 {
    private static final Random rnd = new Random();
    public static void main(String[] args) {
        readBytesFromFile();
        mergeFiles();

    }

    private static void mergeFiles() {
        SequenceInputStream seq = null;
        ArrayList<InputStream> arrayList = new ArrayList<>();
        FileOutputStream out = null;
        try {
            for (int i = 0; i < 5; i++) {
                FileOutputStream o = new FileOutputStream(String.format("fileToMerge%d.txt", i+1));
                for (int j = 0; j < 100; j++) {
                    o.write(rnd.nextInt(100));
                }
                o.close();
                arrayList.add(new FileInputStream(String.format("fileToMerge%d.txt", i+1)));
            }
            Enumeration<InputStream> e = Collections.enumeration(arrayList);
            seq = new SequenceInputStream(e);
            out = new FileOutputStream("mergedFile.txt");
            int b = seq.read();
            while (b != -1) {
                out.write(b);
                b = seq.read();
            }
            out.close();
            seq.close();
            FileInputStream in = new FileInputStream("mergedFile.txt");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                seq.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readBytesFromFile() {
        FileOutputStream out = null;
        FileInputStream in = null;
        try {
            out = new FileOutputStream("testFile.txt");
            for (int i = 0; i < 50; i++) {
                out.write(rnd.nextInt(100));
            }
            out.close();
            byte[] bytes = new byte[50];
            in = new FileInputStream("testFile.txt");
            in.read(bytes);
            for (byte b : bytes) {
                System.out.print(b + " ");
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
