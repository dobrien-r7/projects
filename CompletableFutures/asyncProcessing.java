import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
class Main{
public static void main(String[] args) {
   
   String result = "x";
    try {
            CompletableFuture<Void> future = getFuture()
        .thenAccept(s -> System.out.println("Computation returned: " + s));

        CompletableFuture<Void> future2 = future
        .thenRun(() -> System.out.println("Computation finished."));

         future2.get();
    } catch (Exception e) {
        result = "error";
    }

    System.out.println(result);

}


public static CompletableFuture<String>  getFuture() throws InterruptedException, ExecutionException  {

    CompletableFuture<String> future
     = CompletableFuture.supplyAsync(() -> "Hello");
     
     CompletableFuture<String> future2 = future
     .thenApply(s -> s + " World");

     return future2;
}

}