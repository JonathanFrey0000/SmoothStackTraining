package Assignment_1.A2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RightDigit {
    public static void main(String[] args){

        List<Integer> rightDigit = Arrays.asList(16, 8, 886, 8, 1).stream().map(x -> x % 10).collect(Collectors.toList());
        System.out.println(rightDigit);
    }
}
