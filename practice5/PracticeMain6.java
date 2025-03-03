package practice5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PracticeMain6 {
  public static void main(String[] args) {
    ExecutorService ex = Executors.newCachedThreadPool();
    Future<?> f = ex.submit(new PracticeChild61());

    ex.shutdown();

    try {
      f.get();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ExecutionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("this is main  completed");
  }
}

class PracticeChild61 implements Runnable {

  @Override
  public void run() {
    try {
      System.out.println("this is inside run");
      Thread.sleep(6000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("this is task completed");
  }

}
