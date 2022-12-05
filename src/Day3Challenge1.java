import java.util.Scanner;

public class Day3Challenge1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        String seg1;
        String seg2;
        int index = -1;
        int asciiVal;
        int sum = 0;
        while (true){
            try {
                input = sc.nextLine();
                seg1 = input.substring(0, input.length() / 2);
                seg2 = input.substring(input.length() / 2);
                for (int i = 0; i < seg1.length(); i++) {
                    if (seg2.contains(seg1.substring(i, i + 1))) {
                        index = i;
                        break;
                    }
                }
                asciiVal = seg1.charAt(index);
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
