package A1.Functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author  Jonathan Frey
 */
public class Demo {
    public static void main(String[] args){
        List<Integer> rightDigit = Arrays.asList(1, 22, 93, 886, 1, 0).stream().map(x -> x % 10).collect(Collectors.toList());
        System.out.println(rightDigit);

        List<Integer> doubling = Arrays.asList(1, 2, 3, 4, 5).stream().map(x -> x * 2).collect(Collectors.toList());
        System.out.println(doubling);

        List<String> noX = Arrays.asList("ax","bb","xxax","x","xxaxbxc").stream().map(x -> x.replace("x","")).collect(Collectors.toList());
        System.out.println(noX);
    }
}
