package arunkumar.tut2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturnUsingExecutor {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    Future<Integer> t1 = executorService.submit(new CalculationUsingCallable(1, 3));
    Future<Integer> t2 = executorService.submit(new CalculationUsingCallable(1, 5));
    executorService.shutdown();

    try {
      System.out.println("this is the data t1 " + t1.get());
      System.out.println("this is the data t2 " + t2.get());
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ExecutionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}

class CalculationUsingCallable implements Callable<Integer> {
  int a, b;

  CalculationUsingCallable(int a, int b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public Integer call() throws Exception {
    return a + b;
  }

}
