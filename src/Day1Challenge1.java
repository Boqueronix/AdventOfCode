import java.util.Scanner;

public class Day1Challenge1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        int sum = 0;
        int maxSum = 0;
        int index = 1;
        int maxindex = 1;
        while (true){
            input = sc.nextLine();
            if (!input.equals("")) {
                sum += Integer.parseInt(input);
                System.out.println("Elf number " + index + " is carrying " + sum + " Calories");
            } else {
                if(sum > maxSum){
                    maxSum = sum;
                    maxindex = index;
                }
                System.out.println("The greatest number of Calories is " + maxSum + ", and is carried by elf #" + maxindex);
                index++;
                sum = 0;
            }
        }
    }
}