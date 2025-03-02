package arunkumar.joining;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class File3Join {
  public static void main(String[] args) {
    CountDownLatch latch = new CountDownLatch(3);
    ExecutorService ex = Executors.newFixedThreadPool(3);
    ex.submit(new File3JoinLatch("task-1", 3000, latch));
    ex.submit(new File3JoinLatch("task-2", 2000, latch));
    ex.submit(new File3JoinLatch("task-3", 5000, latch));

    try {
      latch.await();
      System.out.println("all; worker thread done ,");
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("this is main thread");
    ex.shutdown();

  }
}

class File3JoinLatch implements Runnable {

  String taskId;
  Integer sleepTime;
  CountDownLatch latch;

  File3JoinLatch(String taskId, Integer sleepTime, CountDownLatch latch) {
    this.taskId = taskId;
    this.sleepTime = sleepTime;
    this.latch = latch;
  }

  @Override
  public void run() {
    try {
      System.out.println("thread taskid - " + this.taskId + "- thread name - " + Thread.currentThread().getName());

      Thread.sleep(sleepTime);
      System.out
          .println("taskid - " + this.taskId + "- thread name - " + Thread.currentThread().getName() + " - completed");
      latch.countDown();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}