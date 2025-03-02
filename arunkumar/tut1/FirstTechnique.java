package arunkumar.tut1;

public class FirstTechnique {
  public static void main(String[] args) {
    FirstTask ft = new FirstTask();
    Thread t1 = new Thread(ft);
    t1.start();
    try {
      t1.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}

class FirstTask extends Thread {
  public void run() {
    for (int i = 10; i > 0; i--) {
      System.out.println("TICK TICK --- " + i);
    }
  }
}