package practice;

public class mainClass {
  public static void main(String[] args) {
    System.out.println("--------------------------->>>>>>>>>>>>>>>>>>>>>>>>> ");

    MonitorLockExample obj = new MonitorLockExample();

    MonitorLockRunnable rn = new MonitorLockRunnable(obj);

    Thread thr1 = new Thread(rn);

    Thread th1 = new Thread(() -> {
      obj.task1();
    });

    Thread th2 = new Thread(() -> {
      obj.task2();
    });

    Thread th3 = new Thread(() -> {
      obj.task3();
    });

    thr1.start();
    th1.start();
    th2.start();
    th3.start();

    try {
      thr1.join();
      th1.join();
      th2.join();
      th3.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
