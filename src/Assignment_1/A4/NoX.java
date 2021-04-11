package Assignment_1.A4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NoX {
    public static void main(String[] args){

        List<String> noX = Arrays.asList("ax","bb","xxax","x","xxaxbxc").stream().map(x -> x.replace("x","")).collect(Collectors.toList());
        System.out.println(noX);
    }
}
