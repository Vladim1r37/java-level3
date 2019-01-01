public class Task1 {
    public static void main(String[] args) {
        ABCPrinter p = new ABCPrinter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                p.printA();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                p.printB();
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                p.printC();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
