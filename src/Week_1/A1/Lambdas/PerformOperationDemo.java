package Week_1.A1.Lambdas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface PerformOperation {
    boolean check(int a);
}

class PerformOperationDemo {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    PerformOperation isOdd() {
        PerformOperation po = (int a)-> a%2 == 0 ? false : true;
        return po;
    }
    PerformOperation isPrime(){
        PerformOperation po = (int a) -> java.math.BigInteger.valueOf(a).isProbablePrime(1);
        return po;
    }
    PerformOperation isPalindrome(){
        PerformOperation po = (int a) -> Integer.toString(a).equals( new StringBuilder(Integer.toString(a)).reverse().toString() );
        return po;
    }
}


class Solution {

    public static void main(String[] args) throws IOException {

        PerformOperationDemo ob = new PerformOperationDemo();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }

    }
}
