public class Main {

    public static void main(String[] args) throws InterruptedException {

        Box box = new Box();
        Thread a = new Thread(null, box::on, "Человек");
        Thread b = new Thread(null, box::off, "Игрушка");

        a.start();
        b.start();

        a.join();
        b.interrupt();
    }
}
