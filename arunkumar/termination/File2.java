package arunkumar.termination;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class File2 {
  public static void main(String[] args) {
    System.out.println("main thread begun -----");
    ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture<?> f = ses.schedule(new File2Task(), 5, TimeUnit.SECONDS);
    // try {
    // System.out.println(f.get());
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // } catch (ExecutionException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    f.cancel(true);

    System.out.println("shutting down ....");
    // ses.shutdown();
  }
}

class File2Task implements Runnable {

  @Override
  public void run() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      System.out.println("thread inttrupted whie speeping");
    }
    System.out.println("current thread " + Thread.currentThread().getName());
  }

}