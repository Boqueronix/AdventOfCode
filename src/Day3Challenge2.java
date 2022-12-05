import java.util.Scanner;

public class Day3Challenge2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1;
        String input2;
        String input3;
        int index = -1;
        int asciiVal;
        int sum = 0;
        while (true){
            try {
                input1 = sc.nextLine();
                input2 = sc.nextLine();
                input3 = sc.nextLine();
                for (int i = 0; i < input1.length(); i++) {
                    if (input2.contains(input1.substring(i, i + 1)) && input3.contains(input1.substring(i, i + 1))) {
                        index = i;
                        break;
                    }
                }
                asciiVal = input1.charAt(index);
                if (asciiVal > 90) {
                    sum += asciiVal - 96;
                } else {
                    sum += asciiVal - 38;
                }
            } catch (Exception e) {
                System.out.println(sum);
            }
        }
    }
}
