import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        MFP mfp = new MFP();
        ScheduledExecutorService printService = Executors.newScheduledThreadPool(3);
        ScheduledExecutorService scanService = Executors.newScheduledThreadPool(3);

        printService.scheduleAtFixedRate(mfp::print, 0, 50, TimeUnit.MILLISECONDS);
        printService.scheduleAtFixedRate(mfp::print, 0, 50, TimeUnit.MILLISECONDS);
        printService.scheduleAtFixedRate(mfp::print, 0, 50, TimeUnit.MILLISECONDS);

        scanService.scheduleAtFixedRate(mfp::scan, 0, 50, TimeUnit.MILLISECONDS);
        scanService.scheduleAtFixedRate(mfp::scan, 0, 50, TimeUnit.MILLISECONDS);
        scanService.scheduleAtFixedRate(mfp::scan, 0, 50, TimeUnit.MILLISECONDS);

        Thread.sleep(100);

        printService.shutdown();
        scanService.shutdown();
    }
}
