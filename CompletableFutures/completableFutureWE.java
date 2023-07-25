import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
class Main{
public static void main(String[] args) {
   
   String result = "";
    try {
        result = getFuture();
    } catch (Exception e) {
        result = "error";
    }

    System.out.println(result);

}


public static String  getFuture() throws InterruptedException, ExecutionException  {

    CompletableFuture<String> future
     = CompletableFuture.supplyAsync(() -> "Hello");
     
     CompletableFuture<String> future2 = future
     .thenApply(s -> s + " World");

     return future2.get();
}

}