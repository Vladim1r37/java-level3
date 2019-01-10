public class Start extends Stage {
    private volatile boolean isCrossed;

    public Start() {
        this.description = "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!";
    }

    @Override
    public synchronized void go(Car c) {
        if (!isCrossed) {
            System.out.println(description);
            isCrossed = true;
        }
    }
}
