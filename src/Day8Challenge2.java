import java.util.Scanner;
public class Day8Challenge2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = new String[0];
        String line = sc.nextLine();
        int output = 0;
        int[][] grid;
        while (line != null && !line.equals("")){
            String[] temp = new String[input.length + 1];
            for (int i = 0; i < input.length; i++) {
                temp[i] = input[i];
            }
            temp[input.length] = line;
            input = temp;
            line = sc.nextLine();
        }
        output = 4 * (input.length) - 4;
        grid = new int[input.length][input.length];
        for (int i = 0; i < input.length; i++) {
            String s = input[i];
            for (int j = 0; j < s.length(); j++) {
                grid[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }
        int maxScore = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                int test = grid[i][j];
                boolean visL = true;
                int lSight = 0;
                boolean visR = true;
                int rSight = 0;
                boolean visU = true;
                int uSight = 0;
                boolean visD = true;
                int dSight = 0;
                for (int k = j - 1; k > -1; k--) {
                    lSight++;
                    if (grid[i][k] >= test){
                        visL = false;
                        break;
                    }
                }
                for (int k = j + 1; k < grid.length; k++) {
                    rSight++;
                    if (grid[i][k] >= test){
                        visR = false;
                        break;
                    }
                }
                for (int k = i - 1; k > -1; k--) {
                    uSight++;
                    if (grid[k][j] >= test){
                        visU = false;
                        break;
                    }
                }
                for (int k = i + 1; k < grid.length; k++) {
                    dSight++;
                    if (grid[k][j] >= test) {
                        visD = false;
                        break;
                    }
                }
                int score = lSight * rSight * uSight * dSight;
                if (score > maxScore){
                    maxScore = score;
                }
                if (visR || visL || visU || visD){
                    System.out.println("i: " + i + ", j: " + j + ", grid[i][j]: " + grid[i][j] + " is visible");
                    output++;
                }
            }
        }
        System.out.println("Trees visible from outside: " + output);
        System.out.println("Highest score: " + maxScore);
    }
}
