package arunkumar.tut3;

public class ThreadDeamon {
  public static void main(String[] args) {
    System.out.println("---------------- starting --------------- ");
    RandomClass c = new RandomClass();
    Thread t1 = new Thread(c);
    t1.setDaemon(true);
    t1.start();
    System.out.println("this is ThreadDeamon --------------- main " + Thread.currentThread().getName());
  }
}

class RandomClass implements Runnable {

  @Override
  public void run() {
    var v = Thread.currentThread().isDaemon();
    System.out.println("this is run function " + v);
  }
}