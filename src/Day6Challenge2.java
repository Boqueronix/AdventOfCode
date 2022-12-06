import java.util.Scanner;

public class Day6Challenge2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = null;
        int output = 0;
        while (input == null){
            input = sc.nextLine();
        }
//        System.out.println(input);
        for (int i = 14; i < input.length(); i++) {
            String target = input.substring(i - 14, i);
            boolean firstfound = false;
            boolean bothfound = false;
            for (int j = 0; j < 14; j++) {
                firstfound = false;
                bothfound = false;
                for (int k = 0; k < 14; k++) {
                    if (target.charAt(k) == target.charAt(j) && !firstfound){
                        System.out.println("found first repeat of " + target.charAt(k));
                        firstfound = true;
                    } else if (target.charAt(k) == target.charAt(j) && firstfound) {
                        System.out.println("found second repeat of " + target.charAt(k));
                        bothfound = true;
                        break;
                    }
                }
                if (bothfound){
                    break;
                }
            }
            if (bothfound){
                continue;
            } else {
                System.out.println("found output");
                output = i;
                break;
            }
        }
//        System.out.println("Analysis done");
        System.out.println(output);
    }
}
