public class MFP {

    private Object printLock = new Object();
    private Object scanLock = new Object();

    private  int printedPages;
    private  int scannedPages;

    private StringBuilder printSequence = new StringBuilder();
    private StringBuilder scanSequence = new StringBuilder();

    public void print() {
        synchronized (printLock) {
            System.out.println(String.format("Отпечатано %s страниц", pageSequence(++printedPages, printSequence)));
        }
    }


    public void scan() {
        synchronized (scanLock) {
            System.out.println(String.format("Отсканировано %s страниц", pageSequence(++scannedPages, scanSequence)));
        }
    }


    private String pageSequence(int currentPage, StringBuilder pageSequence) {
        return pageSequence.append(currentPage == 1 ? currentPage : ", " + currentPage).toString();
    }
}
