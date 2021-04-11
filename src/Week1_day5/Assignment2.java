package Week1_day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment2 {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 44};

        String newList = Arrays.stream(intArray).mapToObj( i -> (i%2) == 0 ? "e" + i : "o" + i).reduce("", (stringOne, stringTwo) -> stringOne + stringTwo + ",");

        System.out.println(newList);

        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 44);
        String doubling = input.stream().map(x -> x%2 == 0 ? "e" + x : "o" + x).reduce("", (stringOne, stringTwo) -> stringOne + stringTwo + ",");
    }
}
