package arunkumar.tut4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorIsAlive {
  public static void main(String[] args) {
    ExecutorsThread et = new ExecutorsThread();
    ExecutorService es = Executors.newCachedThreadPool();

    Future<?> f = es.submit(et);
    System.out.println("this is done ----------- " + f.isDone());
    es.shutdown();

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("future us done? " + f.isDone());

  }
}

class ExecutorsThread implements Runnable {

  @Override
  public void run() {
    System.out.println("run in thread ------------- " + Thread.currentThread().getName());
  }

}
