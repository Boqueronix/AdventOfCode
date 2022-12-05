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
                        score += 3;
                    } else if (input.charAt(2) == 'Y') {
                        score += 4;
                    } else if (input.charAt(2) == 'Z') {
                        score += 8;
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
                        score += 2;
                    } else if (input.charAt(2) == 'Y') {
                        score += 6;
                    } else if (input.charAt(2) == 'Z') {
                        score += 7;
                    }
                }
            } catch (Exception e) {
                System.out.println(score);
            }
        }
    }
}
