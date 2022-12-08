import java.util.Scanner;
public class Day8Challenge1 {
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
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                int test = grid[i][j];
                boolean visL = true;
                boolean visR = true;
                boolean visU = true;
                boolean visD = true;
                for (int k = 0; k < j; k++) {
                    if (grid[i][k] >= test){
                        visL = false;
                    }
                }
                for (int k = j + 1; k < grid.length; k++) {
                    if (grid[i][k] >= test){
                        visR = false;
                    }
                }
                for (int k = 0; k < i; k++) {
                    if (grid[k][j] >= test){
                        visU = false;
                    }
                }
                for (int k = i + 1; k < grid.length; k++) {
                    if (grid[k][j] >= test){
                        visD = false;
                    }
                }
                if (visR || visL || visU || visD){
                    System.out.println("i: " + i + ", j: " + j + ", grid[i][j]: " + grid[i][j] + " is visible");
                    output++;
                }
            }
        }
        System.out.println(output);
    }
}
