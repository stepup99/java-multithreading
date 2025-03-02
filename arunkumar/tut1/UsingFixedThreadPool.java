package arunkumar.tut1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedThreadPool {
  public static void main(String[] args) {
    System.out.println("ppppppppppppppppppppppppppppppppp===================");
    ExecutorService execService = Executors.newFixedThreadPool(3);
    for (int i = 0; i < 5; i++) {
      execService.execute(new Data(i));
    }

    execService.shutdown();
  }

}

class Data implements Runnable {

  private int taskId;

  public Data(int i) {
    this.taskId = i;
  }

  @Override
  public void run() {
    System.out.println("this taskid --- " + this.taskId + " --- is being executed by  is thread name ========= "
        + Thread.currentThread().getName());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
