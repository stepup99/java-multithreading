package shreyansh;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutDown {
  public static void main(String[] args) {
    DataShutDown ds = new DataShutDown();
    ExecutorService es = Executors.newCachedThreadPool();
    es.submit(ds);
    es.submit(ds);
    es.submit(ds);
    es.submit(ds);
    es.submit(ds);
    es.submit(ds);
    var sdn = es.shutdownNow();
    System.out.println("main thread --------- " + Thread.currentThread().getName());
    System.out.println("shutdo1wnnow sdn size ---------- " + sdn.size());
  }
}

class DataShutDown implements Runnable {

  @Override
  public void run() {

    // try {
    //   Thread.sleep(3000);
    // } catch (InterruptedException e) {
    //   // TODO Auto-generated catch block
    //   e.printStackTrace();
    // }

    System.out.println("this is DataShutDown in " + Thread.currentThread().getName());
  }

}
