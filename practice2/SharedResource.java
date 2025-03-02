package practice2;

public class SharedResource {

  boolean itemAvailable = false;

  public synchronized void addItem() {
    System.out.println("adding item to the resource");
    itemAvailable = true;
    notifyAll();
  }

  public synchronized void consumeItem() {
    System.out.println("consume item method invoked by" + Thread.currentThread().getName());
    while (!itemAvailable) {
      try {
        wait();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    System.out.println("consume by" + Thread.currentThread().getName());
    itemAvailable = false;
  }
}
