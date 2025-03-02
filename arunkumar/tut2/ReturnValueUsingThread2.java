package arunkumar.tut2;

public class ReturnValueUsingThread2 {
  public static void main(String[] args) {
    Data1 d1 = new Data1(3, 4, new NotifyResult("task-1"));
    Data1 d2 = new Data1(31, 4, new NotifyResult("task-2"));
    Data1 d3 = new Data1(35, 4, new NotifyResult("task-3"));

    Thread t1 = new Thread(d1);
    Thread t2 = new Thread(d2);
    Thread t3 = new Thread(d3);

    t1.start();
    t2.start();
    t3.start();

  }
}

interface Notifier<T> {
  void call(T t);
}

class NotifyResult implements Notifier<Integer> {
  private String task;

  NotifyResult(String task) {
    this.task = task;
  }

  @Override
  public void call(Integer t) {
    System.out.println("Task: " + task + " completed with sum: " + t);
  }
}

class Data1 implements Runnable {
  private int a, b, sum;
  private Notifier<Integer> notifier;

  Data1(int a, int b, Notifier<Integer> notifier) {
    this.a = a;
    this.b = b;
    this.notifier = notifier;
  }

  @Override
  public void run() {
    sum = a + b;
    notifier.call(sum);
  }
}
