import java.util.Scanner;

public class Day9Challenge1 {
    public static int[] headCoords = {0, 0};
    public static int[] tailCoords = {0, 0};
    public static int[][] tailTrail = {{0, 0}};
    public static void main(String[] args) {
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
        headCoords[0]--;
    }
    public static void headRight(){
        headCoords[0]++;
    }
    public static void headUp(){
        headCoords[1]++;
    }
    public static void headDown(){
        headCoords[1]--;
    }
    public static void follow(){
        int xHead = headCoords[0];
        int yHead = headCoords[1];
        int xTail = tailCoords[0];
        int yTail = tailCoords[1];
        if (xHead - xTail == 2){
            tailCoords[0]++;
            if (Math.abs(yTail - yHead) == 1){
                tailCoords[1] = headCoords[1];
            }
        } else if (xHead - xTail == -2){
            tailCoords[0]--;
            if (Math.abs(yTail - yHead) == 1){
                tailCoords[1] = headCoords[1];
            }
        } else if (yHead - yTail == 2){
            tailCoords[1]++;
            if (Math.abs(xTail - xHead) == 1){
                tailCoords[0] = headCoords[0];
            }
        } else if (yHead - yTail == -2){
            tailCoords[1]--;
            if (Math.abs(xTail - xHead) == 1){
                tailCoords[0] = headCoords[0];
            }
        }
        int[][] temp = new int[tailTrail.length + 1][2];
        for (int i = 0; i < tailTrail.length; i++) {
            temp[i] = tailTrail[i];
        }
        temp[tailTrail.length] = new int[]{tailCoords[0], tailCoords[1]};
        tailTrail = temp;
    }
}