public class MonitorLockClass {
  public synchronized void m1() {
    System.out.println("this is m1");
  }

  public void m2() {
    synchronized (this) {
      System.out.println("this is m2");
    }
  }

  public void m3() {
    System.out.println("this is m3");
  }

}