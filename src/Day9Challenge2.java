import java.util.Scanner;

public class Day9Challenge2 {
    public static int[][] tailTrail = {{0, 0}};
    public static void main(String[] args) {
        StdDraw.setScale(-350, 350);
        StdDraw.enableDoubleBuffering();
        for (int i = 0; i < 10; i++) {
            Knot.all[i] = new Knot(i);
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("")){
            for (int i = 0; i < Integer.parseInt(input.substring(2)); i++) {
                if (input.charAt(0) == 'L'){
                    headLeft();
                    follow();
                } else if (input.charAt(0) == 'R'){
                    headRight();
                    follow();
                } else if (input.charAt(0) == 'U'){
//                    System.out.println("UP");
                    headUp();
                    follow();
                } else {
                    headDown();
                    follow();
                }
            }
            input = scanner.nextLine();
        }
        int[][] uniques = new int[0][2];
        for (int i = 0; i < tailTrail.length; i++) {
            boolean unique = true;
            for (int[] u: uniques) {
                if (tailTrail[i][0] == u[0] && tailTrail[i][1] == u[1]){
                    unique = false;
                    break;
                }
            }
            if (unique){
                int[][] temp = new int[uniques.length + 1][2];
                for (int j = 0; j < uniques.length; j++) {
                    temp[j] = uniques[j];
                }
                temp[uniques.length] = tailTrail[i];
                uniques = temp;
            }
        }
        System.out.println(uniques.length);
    }
    public static void headLeft(){
        Knot.all[0].coords[0]--;
    }
    public static void headRight(){
        Knot.all[0].coords[0]++;
    }
    public static void headUp(){
        Knot.all[0].coords[1]++;
    }
    public static void headDown(){
        Knot.all[0].coords[1]--;
    }
    public static void follow(){
        for (int i = 1; i < 10; i++) {
            Knot.all[i].follow();
        }
        Knot.all[9].draw();
//        System.out.println("X: " + Knot.all[8].coords[0] + ", Y: " + Knot.all[8].coords[1]);
    }
}
class Knot{
   public static Knot[] all = new Knot[10];
   public int[] coords = {0,0};
   public final int ID;
   public Knot(int id){
       ID = id;
   }
   public void follow(){
       int xHead = all[ID - 1].coords[0];
       int yHead = all[ID - 1].coords[1];
       int xTail = coords[0];
       int yTail = coords[1];
       if (xHead - xTail == 2){
//           System.out.println("right");
           coords[0]++;
           if (Math.abs(yTail - yHead) == 1){
               coords[1] = all[ID - 1].coords[1];
           }
       } else if (xHead - xTail == -2){
//           System.out.println("left");
           coords[0]--;
           if (Math.abs(yTail - yHead) == 1){
               coords[1] = all[ID - 1].coords[1];
           }
       } else if (yHead - yTail == 2){
//           System.out.println("up");
           coords[1]++;
           if (Math.abs(xTail - xHead) == 1){
               coords[0] = all[ID - 1].coords[0];
           }
       } else if (yHead - yTail == -2){
//           System.out.println("down");
           coords[1]--;
           if (Math.abs(xTail - xHead) == 1){
               coords[0] = all[ID - 1].coords[0];
           }
       }
       if (this == all[9]) {
           int[][] temp = new int[Day9Challenge2.tailTrail.length + 1][2];
           for (int i = 0; i < Day9Challenge2.tailTrail.length; i++) {
               temp[i] = Day9Challenge2.tailTrail[i];
           }
           temp[Day9Challenge2.tailTrail.length] = new int[]{coords[0], coords[1]};
           Day9Challenge2.tailTrail = temp;
       }
   }
   public void draw(){
       StdDraw.filledCircle(coords[0], coords[1], 1);
   }
}