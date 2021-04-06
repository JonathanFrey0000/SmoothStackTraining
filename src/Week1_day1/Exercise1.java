package Week1_day1;

public class Exercise1 {
    static void printDots(int a){
        for(int i =0;i<a;i++){
            System.out.print(".");
        }
        System.out.println();
    }

    static void printStar(){
        System.out.print("*");
    }
    static void printBlank(){
        System.out.print(" ");
    }

    public static void main(String[] args){

        //1)
        System.out.println("1)");

        for(int a=0;a<4;a++){
            for(int b=0;b<a+1;b++){
                printStar();
            }
            System.out.println();
        }
        printDots(9);

        //2)
        System.out.println();
        System.out.println("2)");

        printDots(10);
        for(int a=4;a>0;a--){
            for(int b=a;b>0;b--){
                printStar();
            }
            System.out.println();
        }

        //3)
        System.out.println();
        System.out.println("3)");
        for (int a=1; a<5; a++) {
            for (int b=a; b<6;b++){
                printBlank();
            }
            for(int c=1; c<(a*2);c++){
                printStar();
            }
            System.out.println();
        }
        printDots(11);

        //4)
        System.out.println();
        System.out.println("4)");

       printDots(12);
        for (int a=6; a>1; a--) {
            for (int b= a; b<8; b++) {
                printBlank();
            }
            for (int c=1; c<((a-2)*2); c++) {
                printStar();
            }
            System.out.println();
        }
}}
