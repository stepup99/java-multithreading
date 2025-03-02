package practice;

public class MonitorLockExample {
  public synchronized void task1() {

    System.out.println("task1 thread with name ------>>>>>>>>>>> " + Thread.currentThread().getName()
        + "  --- object hashcode --- " + this.hashCode());
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void task2() {
    System.out.println("just before doing task 2-------- " + Thread.currentThread().getName());
    synchronized (this) {
      System.out.println(
          "task2 thread with name " + Thread.currentThread().getName() + " ------- object hashcode " + this.hashCode());
    }
  }

  public void task3() {
    System.out.println(
        "task3 thread with name " + Thread.currentThread().getName() + " ------- object hashcode " + this.hashCode());
  }
}
