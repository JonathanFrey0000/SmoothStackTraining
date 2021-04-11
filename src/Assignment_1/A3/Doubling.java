package Assignment_1.A3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Doubling {
    public static void main(String[] args){

        List<Integer> doubling = Arrays.asList(1, 2, 3, 4, 5).stream().map(x -> x * 2).collect(Collectors.toList());
        System.out.println(doubling);
    }
}
