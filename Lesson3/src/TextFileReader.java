import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class TextFileReader {
    public static void main(String[] args) {
        System.out.println("Открывается файл textFile.txt");
        try (RandomAccessFile raf = new RandomAccessFile("textFile.txt", "r")) {
            long numOfPages = raf.length() / 1800 + 1;
            System.out.println(raf.length());
            System.out.println(String.format("В файле %d страниц", numOfPages ));
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Введите номер страницы. /q - выход");
                String str = sc.nextLine();
                if (str.startsWith("/q")) {
                    break;
                }
                long pageNum = Long.valueOf(str);
                long offset = (pageNum - 1) * 1800;
                raf.seek(offset);
                long beginTime = System.currentTimeMillis();
                if (offset >= raf.length()) {
                    System.out.println(String.format("В файле %d страниц", numOfPages));
                } else {
                    byte[] pageContent;
                    if (pageNum == numOfPages) {
                        pageContent = new byte[(int) (raf.length() - offset)];
                    } else {
                        pageContent = new byte[1800];
                    }
                    raf.readFully(pageContent);
                    System.out.println(new String(pageContent));
                    System.out.println(String.format("Чтение страницы заняло %d миллисекунд",
                            System.currentTimeMillis() - beginTime));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
