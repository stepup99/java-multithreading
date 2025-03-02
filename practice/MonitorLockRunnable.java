package practice;

public class MonitorLockRunnable implements Runnable {
  MonitorLockExample obj;

  MonitorLockRunnable(MonitorLockExample obj) {
    this.obj = obj;
  }

  @Override
  public void run() {
    obj.task1();
  }

}
