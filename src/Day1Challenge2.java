import java.util.Scanner;

public class Day1Challenge2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        int sum = 0;
        int topSum = 0;
        int secondSum = 0;
        int thirdSum = 0;
        int index = 1;
        int maxindex = 1;
        while (true){
            input = sc.nextLine();
            if (!input.equals("")) {
                sum += Integer.parseInt(input);
                System.out.println("Elf number " + index + " is carrying " + sum + " Calories");
            } else {
                if(sum > topSum){
                    thirdSum = secondSum;
                    secondSum = topSum;
                    topSum = sum;
                    maxindex = index;
                } else if (sum > secondSum) {
                    thirdSum = secondSum;
                    secondSum = sum;
                } else if (sum > thirdSum) {
                    thirdSum = sum;
                }
                System.out.println((topSum + secondSum + thirdSum));
                index++;
                sum = 0;
            }
        }
    }
}
