package Week_1.Week1_day5;

import java.util.Arrays;
import java.util.Comparator;

public class Assignment1 {
    static public int yourMethod(String a, String b){
        return Integer.compare(a.contains("e")  ? 0 : 1, b.contains("e") ? 0 : 1);
    }

    public static void main(String[] args){
        String[] test = {"a","bbb","hello","c","ddddddd","ee"};

        Arrays.sort(test, Comparator.comparingInt(String::length));
        System.out.println("Sorting array by length:");
        System.out.println(Arrays.toString(test)+ "\n");

        Arrays.sort(test, (String a, String b) -> b.length() - a.length());
        System.out.println("Sorting array by reverse length");
        System.out.println(Arrays.toString(test)+ "\n");

        Arrays.sort(test, Comparator.comparingInt((String a) -> a.charAt(0)));
        System.out.println("Sorting array alphabetically by the first character only");
        System.out.println(Arrays.toString(test)+ "\n");

        Arrays.sort(test, Comparator.comparingInt(a -> a.contains("e") ? 0 : 1));
        System.out.println("Sorting by string that contain 'e' first:");
        System.out.println(Arrays.toString(test)+ "\n");

        Arrays.sort(test, (a, b) -> yourMethod(a, b));
        System.out.println("Sorting by string that contain 'e' first with static helper method:");
        System.out.println(Arrays.toString(test)+ "\n");



    }
}
