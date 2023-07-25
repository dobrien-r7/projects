import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class comparator {

    String[] yetToSortedArray = {"Abc","hello world","nihao?", "xyz", "hello worle", "abcd", "aaa", "xyz", "def", "hello wordle", "hello worla"};
    public static void main(String[] args){
        comparator mc = new comparator();
        // mc.parallelSortArray();
        // //this.sortArray();
        // System.out.println("-------");
        // mc.comparatorSort();
        // System.out.println("-------");
        // mc.stolenFromStackOverflow();
        System.out.println("-------");
        mc.sortAlphaThenLength();
        System.out.println("-------");
        mc.sortBackwardsLength();
        System.out.println("-------");
        mc.sortBackwardsLengthOnly();
        System.out.println("-------");
        System.out.println("*******");
        mc.whatAboutObjects();
    }
    public void parallelSortArray(){
        Arrays.parallelSort(yetToSortedArray);

        for(String str : yetToSortedArray){
            System.out.println(str + ", ");
        }
    }
    public void comparatorSort(){
        Comparator<String> lengthCompare = (a, b) -> Integer.compare(a.length(), b.length());
        Arrays.parallelSort(yetToSortedArray, lengthCompare);
        
        for(String str : yetToSortedArray){
            System.out.println(str + ", ");
        }
    }
    public void stolenFromStackOverflow(){
        Arrays.parallelSort(yetToSortedArray, Comparator.comparing(String::length));
        for(String str : yetToSortedArray){
            System.out.println(str + ", ");
        }
    }

    //want it to sort by length first then alphabetical... lets try combining first
    public void sortAlphaThenLength(){
        Arrays.sort(yetToSortedArray, Comparator.comparing(String::length).thenComparing(String::compareToIgnoreCase));
        printResults();
    }

    public void sortBackwardsLength(){
        Arrays.sort(yetToSortedArray, Comparator.comparing(String::length).reversed().thenComparing(String::compareToIgnoreCase));
        printResults();
    }

    public void sortBackwardsLengthOnly(){
        Arrays.sort(yetToSortedArray, Comparator.comparing(String::length).reversed());
        printResults();
    }

    public void printResults(){
        for(String str : yetToSortedArray){
            System.out.println(str + ", ");
        }
    }

    public void printResults(objExample[] arr){
        for(objExample obj : arr){
            System.out.println(obj.name + ", ");
        }
    }

    public void whatAboutObjects(){
        objExample[] objArr;
        objArr = new objExample[5];
        objArr[0] = new objExample(123, "lemons");
        objArr[1] = new objExample(456, "lemona");
        objArr[2] = new objExample(12, "melons");
        objArr[3] = new objExample(1, "xyz");
        objArr[4] = new objExample(122, "aaa");

        // Optional.of(hostNames.stream()
        //  .sorted(Comparator.comparing((h -> HostNameSource.fromString(h.getSource()))))
        //  .findFirst()
        //  .orElse(null));
        Arrays.sort(objArr, Comparator.comparing(String::length).reversed());
        Optional<objExample> optional = Optional.of(objExample.stream());

        printResults(objArr);
    }


    class objExample{
        public int id;
        public String name;

        objExample(int id, String name)
        {
            this.id = id;
            this.name = name;
        }

        public String getSource() {
            return this.name;
         }
    }

}
