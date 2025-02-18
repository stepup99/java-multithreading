public class mainClass {
  public static void main(String[] args) throws InterruptedException {
    // System.out.println("main thread start" + Thread.currentThread().getName());
    // MutlithreadingLearning ml = new MutlithreadingLearning();
    // System.out.println("this is main class");
    // Thread t1 = new Thread(ml);
    // t1.start();
    // System.out.println("main thread ends " + Thread.currentThread().getName());
    // t1.join();

    // ThreadClass th = new ThreadClass();
    // th.start();

    // System.out.println("this is main thread ends ---- " +
    // Thread.currentThread().getName());

    MonitorLockClass mc = new MonitorLockClass();

    Thread t1 = new Thread(() -> {
      mc.m1();
    });

    Thread t2 = new Thread(() -> {
      mc.m2();
    });

    Thread t3 = new Thread(() -> {
      mc.m3();
    });

    t1.start();
    t2.start();
    t3.start();

  }

}
