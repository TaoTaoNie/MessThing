/* Cheng-Ting, Peng (Justin)
   Assignment #2
   The purpose of the assignment is to practice setting up for loop 
        and understanding the conecept of class constant. Furthermore, to set up a
        class constant within our loop.
   Total Hour Spent: 7 hours */

public class DrawRocket {
    public static final int HEIGHT = 20;

    public static void main(String[] args) {
        cone();
        symbol();
        triangle();
        opptri();
        symbol();
        opptri();
        triangle();
        symbol();
        cone();
    }
    
    public static void cone() {
        for (int line = 1; line <= (2*HEIGHT)-1; line++) {
           for (int space = (2*HEIGHT)-1; space >= line; space--) {
              System.out.print(" ");
           }
           for (int slash = 1; slash <= line; slash++) {
              System.out.print("/");
           }
                      
           for (int star = 1; star <= 2; star++) {
              System.out.print("*");
           }
           
           for (int backslash = 1; backslash <= line; backslash++) {
              System.out.print("\\");
           }
           System.out.println();
        }
    }

    public static void symbol() {
        System.out.print("+");
        for (int i = 1; i <= 2*HEIGHT; i++) {
           System.out.print("=*");
        }
        System.out.println("+");
    }
    
    public static void triangle() {
        for (int line=1; line<=HEIGHT; line++) {
           System.out.print("|");
           for (int dot=1; dot<=(HEIGHT-line); dot++) {
              System.out.print(".");
           }
           for (int slash=1; slash<=line; slash++) {
              System.out.print("/\\");
           }
           for (int point=1; point<=-(2*line)+HEIGHT*2; point++) {
               System.out.print(".");
           }
           for (int slash=1; slash<=line; slash++) {
              System.out.print("/\\"); 
           }
           for (int dot=1; dot<=(HEIGHT-line); dot++) {
              System.out.print(".");
           }
           System.out.print("|");
           System.out.println();
        }
    }
    
    public static void opptri() {
        for (int line=1; line<=HEIGHT; line++) {
           System.out.print("|");
           for (int dot=1; dot<=line-1; dot++) {
              System.out.print(".");
           }
           for (int slash=1; slash<=(-1*line)+HEIGHT+1; slash++) {
              System.out.print("\\/");
           }
           for (int point=1; point<=(2*line)-2; point++) {
              System.out.print(".");
           }
           for (int slash=1; slash<=(-1*line)+HEIGHT+1; slash++) {
              System.out.print("\\/");
           }
           for (int dot=1; dot<=line-1; dot++) {
              System.out.print(".");
           }
           System.out.print("|");
           System.out.println();
        }
    }
}
