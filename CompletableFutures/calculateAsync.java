import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Main{
public static void main(String[] args) {
    
    System.out.println(getFuture());

}


public static String getFuture()  {

    String result = "";
    try {
     Future<String> completableFuture = calculateAsync();
     result = completableFuture.get();
        
    } catch (Exception e) {
        result = "Error";
    }
    //assertEquals("Hello", result);
    return result;
}


public static Future<String> calculateAsync() throws InterruptedException {
    CompletableFuture<String> completableFuture = new CompletableFuture<>();

    Executors.newCachedThreadPool().submit(() -> {
        Thread.sleep(500);
        completableFuture.complete("Hello");
        return null;
    });

    return completableFuture;
}

}