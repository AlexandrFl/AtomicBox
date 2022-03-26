import java.util.concurrent.atomic.AtomicBoolean;

public class Box {
    private final AtomicBoolean local = new AtomicBoolean(false);
    private final int SLEEP = 1000;

    public void on() {
        int i = 0;
        try {
            while (i != 8) {
                while (local.get()) ;
                Thread.sleep(SLEEP);
                System.out.println(Thread.currentThread().getName() + " включает тумблер");
                local.set(true);
                i++;
            }
            System.out.println("Человек уходит");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void off() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                while (!local.get()) ;
                Thread.sleep(SLEEP);
                System.out.println(Thread.currentThread().getName() + " выключает тумблер\n");
                local.set(false);
            }
            System.out.println("Игрушку отключили от питания");
        } catch (InterruptedException e) {
            System.out.println("Игрушку отключили от питания в открытом состоянии");
        }
    }
}
