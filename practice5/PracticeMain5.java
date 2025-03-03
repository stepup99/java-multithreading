package practice5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PracticeMain5 {
  public static void main(String[] args) {
    ExecutorService es = Executors.newCachedThreadPool();

    var task1 = new PracticeMainChild51();
    var task2 = new PracticeMainChild52();
    var f1 = es.submit(task1);
    var f2 = es.submit(task2);

    es.shutdown();
    System.out.println("this is main class before timer");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    f1.cancel(true);
    f2.cancel(true);
    es.shutdownNow();
    System.out.println("this is main -------------- ");
  }
}

class PracticeMainChild51 implements Runnable {

  @Override
  public void run() {
    try {
      Thread.sleep(6000);
    } catch (InterruptedException e) {
      System.out.println("PracticeMainChild5 interrupted while sleeping " + Thread.currentThread().getName());
      e.printStackTrace();
    }
  }

}

class PracticeMainChild52 implements Callable<String> {

  @Override
  public String call() throws Exception {
    Thread.sleep(12000);
    return "data practice 52 class";
  }

}