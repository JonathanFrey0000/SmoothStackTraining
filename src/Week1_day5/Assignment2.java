package Week1_day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment2 {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 44);
        String result = input.stream().map(x -> x%2 == 0 ? "e" + x : "o" + x).reduce("", (a,b) -> a + b + ",");
        System.out.println(result);
    }
}
