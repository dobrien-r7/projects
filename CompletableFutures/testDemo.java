import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
class Main{
public static void main(String[] args) {
   
   String result = "";
    try {
        result = runDeactivation();
    } catch (Exception e) {
        result = "error";
    }

    System.out.println(result);

}


public static String  runDeactivation() throws InterruptedException, ExecutionException  {

    CompletableFuture<String> deactivation
     = CompletableFuture.supplyAsync(() -> "Deactivated");
     
     return deactivation.get();
}

}