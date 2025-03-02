package arunkumar.termination;

public class File1 {
  public static void main(String[] args) {
    File1Data f1d = new File1Data();
    Thread t1 = new Thread(f1d);
    t1.start();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    t1.interrupt();

  }
}

class File1Data implements Runnable {

  @Override
  public void run() {
    while (!Thread.currentThread().isInterrupted()) {
      System.out.println("this is the thread picked up - " + Thread.currentThread().getName());
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println("thread was intterupted while sleeping !!!");
        return;
      }
      System.out.println("thread task done - " + Thread.currentThread().getName());
    }
  }

}
