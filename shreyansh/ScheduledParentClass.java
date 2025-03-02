package shreyansh;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledParentClass {
  public static void main(String[] args) {
    System.out.println("this is starting of main class --- " + Thread.currentThread().getName());
    ScheduleClass shc1 = new ScheduleClass("task-1");
    ScheduledExecutorService s = Executors.newScheduledThreadPool(1);
    s.scheduleWithFixedDelay(shc1, 0, 3, TimeUnit.SECONDS);

    s.schedule(() -> {
      System.out.println("shutting down the thread");
      s.shutdown();
    }, 20, TimeUnit.SECONDS);

    try {
      if (s.awaitTermination(5, TimeUnit.SECONDS)) {
        System.out.println("task is completed with in timeout");
      } else {
        System.out.println("timeout reached some task is still running ");
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("this is ending of main class --- " + Thread.currentThread().getName());
  }
}

class ScheduleClass implements Runnable {

  private String task;

  ScheduleClass(String task) {
    this.task = task;
  }

  @Override
  public void run() {
    System.out
        .println(
            "pick tasKID - " + this.task + "- thread-id " + Thread.currentThread().getName());
    try {
      Thread.sleep(6000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out
        .println(
            "complete tasKID - " + this.task + "- thread-id " + Thread.currentThread().getName());
  }

}