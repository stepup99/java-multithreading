package arunkumar.tut2;

public class ReturnValueUsingThread {
  public static void main(String[] args) {
    System.out.println("----------------- this is normal thread ------------");
    Data d = new Data(10, 20, 10000);

    Thread t1 = new Thread(d);
    t1.start();
    System.out.println("this is sum ---------- " + d.sum());
    try {
      t1.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}

class Data implements Runnable {

  private int a;
  private int b;
  private Boolean bool = false;
  private int timeOut;
  private int sum;

  Data(int a, int b, int timeOut) {
    this.a = a;
    this.b = b;
    this.timeOut = timeOut;
  }

  @Override
  public void run() {
    synchronized (this) {
      try {
        Thread.sleep(timeOut);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      bool = true;
      sum = a + b;
      notify();
    }
  }

  public int sum() {
    synchronized (this) {
      while (!bool) {
        try {
          wait();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      return a + b;
    }

  }

}
