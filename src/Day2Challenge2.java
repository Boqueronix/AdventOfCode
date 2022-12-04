import java.util.Scanner;

public class Day2Challenge2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        int score = 0;
        while (true){
            input = sc.nextLine();
            try {
// They choose Rock
                if (input.charAt(0) == 'A') {
                    if (input.charAt(2) == 'X') {
                        score += 4;
                    } else if (input.charAt(2) == 'Y') {
                        score += 8;
                    } else if (input.charAt(2) == 'Z') {
                        score += 3;
                    }
                }
//They choose Paper
                else if (input.charAt(0) == 'B') {
                    if (input.charAt(2) == 'X') {
                        score += 1;
                    } else if (input.charAt(2) == 'Y') {
                        score += 5;
                    } else if (input.charAt(2) == 'Z') {
                        score += 9;
                    }
                }
//They choose Scissors
                else if (input.charAt(0) == 'C') {
                    if (input.charAt(2) == 'X') {
                        score += 7;
                    } else if (input.charAt(2) == 'Y') {
                        score += 2;
                    } else if (input.charAt(2) == 'Z') {
                        score += 6;
                    }
                }
            } catch (Exception e) {
                System.out.println(score);
            }
        }
    }
}
