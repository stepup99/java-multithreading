package arunkumar.tut3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExecutorDeamon {
  public static void main(String[] args) {
    DataDeamon dd = new DataDeamon();

    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.submit(dd);

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("this is main class");
    executorService.shutdown();
  }
}

class NewThreadFactory implements ThreadFactory {
  @Override
  public Thread newThread(Runnable r) {
    Thread t = new Thread("workdatathread");
    t.setDaemon(true);
    return t;
  }
}

class DataDeamon implements Runnable {

  @Override
  public void run() {
    System.out.println("this is deamon thread");
  }

}
