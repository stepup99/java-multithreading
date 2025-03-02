package practice3;

public class mainClass {
  public static void main(String[] args) {
    ThreadSetPriority t1 = new ThreadSetPriority();
    ThreadSetPriority t2 = new ThreadSetPriority();
    ThreadSetPriority t3 = new ThreadSetPriority();

    t1.setPriority(Thread.MIN_PRIORITY); // Priority = 1
    t2.setPriority(Thread.NORM_PRIORITY); // Priority = 5 (default)
    t3.setPriority(Thread.MAX_PRIORITY); // Priority = 10

    t1.start();
    t2.start();
    t3.start();

    try {
      t1.join();
      t2.join();
      t3.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
