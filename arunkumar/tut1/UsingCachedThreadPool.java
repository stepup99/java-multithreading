package arunkumar.tut1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingCachedThreadPool {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    for (int i = 0; i < 10; i++) {
      executorService.execute(new Data(i));
    }
    executorService.shutdown();
  }

}

class Data implements Runnable {
  private int taskId;

  Data(int i) {
    this.taskId = i;
  }

  @Override
  public void run() {

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("this is the task id -----------" + this.taskId + "--------- - executed-------- "
        + Thread.currentThread().getName());
  }
}
