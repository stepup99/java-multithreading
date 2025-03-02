package practice4;

public class MainClass {
  public static void main(String[] args) {
    System.out.println("main thread started");
    DeamonThread dt = new DeamonThread();
    Thread t1 = new Thread(() -> {
      dt.call();
    }, "thread-1");
    t1.setDaemon(true);
    t1.start();

    // try {
    // t1.join();
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }

    System.out.println("main thread getting over");
  }
}
