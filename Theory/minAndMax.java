package Theory;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class minAndMax{
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(10,20,5,15,25);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("min: "+min.orElseThrow());
        System.out.println("max: "+max.orElseThrow());
    }
}