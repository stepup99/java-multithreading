package arunkumar.tut1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class customThreadFacory implements ThreadFactory {

  private int count = 0;

  @Override
  public Thread newThread(Runnable r) {
    Thread t = new Thread(r, "Mack-" + ++count);
    return t;
  }

}

public class UsingSingleThreadPool {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i < 10; i++) {
      executorService.execute(new Data(i));
    }

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("--------------- ttttttttttttttt");

    for (int i = 0; i < 4; i++) {
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
      Thread.sleep((long) Math.random() * 1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("this is the task id -----------" + this.taskId + "--------- - executed-------- "
        + Thread.currentThread().getName());
  }
}
