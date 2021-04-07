package Week1_day2.Exercise_1_and_2;

/**
 * @author  Jonathan Frey
 */

public class Assignment {

    //method to find and return max value of 2D array and its index
    public static String findMaxValueAndIndex(int[][] input) {
        int max = 0, r = 0, c = 0;

        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[row].length; col++) {
                int value = input[row][col];
                if (value > max) {
                    max = value;
                    r = row;
                    c = col;
                }
            }
        }
        return "2D Array max value is: " + max + " and its index is: [" + r + "][" + c + "].";
    }
    public static void main(String[] args){

        System.out.print("1)");

        System.out.print("Adding command-line arguments: ");
        int result=0;
        for(String s: args){
            try {
                result += Integer.parseInt(s);
            }
            catch(NumberFormatException e){
                continue;
            }
        }
        System.out.println(result);

        System.out.print("2)");

        int[][] test = {{1,2,3,20,5},{6,7,8,9,10},{11,12,13,14,15}};
        System.out.println(findMaxValueAndIndex(test));

    }
}
