import java.util.Scanner;

public class Day6Challenge1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = null;
        int output = 0;
        while (input == null){
            input = sc.nextLine();
        }
        System.out.println(input);
        for (int i = 4; i < input.length(); i++) {
            String target = input.substring(i - 4, i);
            System.out.println(target);
            if (target.charAt(0) == target.charAt(1) || target.charAt(0) == target.charAt(2) || target.charAt(0) == target.charAt(3)){
                System.out.println(i + " doesnt work");
                continue;
            } else if (target.charAt(1) == target.charAt(2) || target.charAt(1) == target.charAt(3)) {
                System.out.println(i + " doesnt work");
                continue;
            } else if (target.charAt(2) == target.charAt(3)) {
                System.out.println(i + " doesnt work");
                continue;
            } else {
                System.out.println("found");
                output = i;
                break;
            }
        }
        System.out.println("Analysis done");
        System.out.println(output);
    }
}
