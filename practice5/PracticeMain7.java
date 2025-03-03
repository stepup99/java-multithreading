package practice5;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PracticeMain7 {
  public static void main(String[] args) {
    ExecutorService e = Executors.newCachedThreadPool();
    CompletionService<String> c = new ExecutorCompletionService<String>(e);
    c.submit(new PracticeMain71("task-1"));
    c.submit(new PracticeMain71("task-2"));
    c.submit(new PracticeMain71("task-3"));
    c.submit(new PracticeMain71("task-4"));
    c.submit(new PracticeMain71("task-5"));

    e.shutdown();

    for (int i = 0; i < 5; i++) {
      try {
        System.out.println("this is loop " + c.take().get());
      } catch (InterruptedException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      } catch (ExecutionException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }
    System.out.println("main task completion");
  }
}

class PracticeMain71 implements Callable<String> {

  private String taskid;

  PracticeMain71(String taskid) {
    this.taskid = taskid;
  }

  @Override
  public String call() throws Exception {
    return this.taskid;
  }

}
