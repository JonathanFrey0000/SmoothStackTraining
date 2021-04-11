package Week1_day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment3 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("abc", "bbb","aaaa","a","awq","zaa");
        List<String> result = words.stream().filter( string -> string.charAt(0) == 'a' && string.length() == 3 ).collect(Collectors.toList());
        result.forEach(x -> System.out.println(x));
    }
}
