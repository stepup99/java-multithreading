package practice3;

public class ThreadSetPriority extends Thread {
  public void run() {
    System.out.println("thread name is ----------- " + Thread.currentThread().getName());
  }
}
