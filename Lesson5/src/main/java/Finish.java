
public class Finish extends Stage {
    private boolean isCrossed;
    private int carsCount;

    public Finish(int carsCount) {
        this.description = "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!";
        this.carsCount = carsCount;

    }

    @Override
    public synchronized void go(Car c) {
        if (!isCrossed) {
            System.out.println(c.getName() + " - WIN");
            isCrossed = true;
        }
        carsCount--;
        if (carsCount == 0) {
            System.out.println(description);
        }
    }
}
