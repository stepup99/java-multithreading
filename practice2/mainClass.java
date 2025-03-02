package practice2;

public class mainClass {

  public static void main(String[] args) {

    SharedResource sr = new SharedResource();

    Thread add = new Thread(() -> {
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      sr.addItem();
    });

    Thread consume = new Thread(() -> {
      sr.consumeItem();
    });
    add.start();
    consume.start();
    try {
      add.join();
      consume.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
