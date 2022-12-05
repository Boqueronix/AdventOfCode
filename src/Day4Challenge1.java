import java.util.Scanner;

public class Day4Challenge1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        int num1 = -1;
        int num2 = -1;
        int num3 = -1;
        int num4 = -1;
        int count = 0;
        while (true){
            try {
                input = sc.nextLine();
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == '-') {
                        num1 = Integer.parseInt(input.substring(0, i));
                        for (int j = i; j < input.length(); j++) {
                            if (input.charAt(j) == ',') {
                                num2 = Integer.parseInt(input.substring(i + 1, j));
                                for (int k = j; k < input.length(); k++) {
                                    if (input.charAt(k) == '-') {
                                        num3 = Integer.parseInt(input.substring(j + 1, k));
                                        num4 = Integer.parseInt(input.substring(k + 1));
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                if (num1 == -1 || num2 == -1 || num3 == -1 || num4 ==-1){
                    throw new Exception();
                }
                if ((num1 <= num3 && num2 >= num4) || (num1 >= num3 && num2 <= num4)){
                    count++;
                }
                System.out.println(count);
            } catch (Exception e){
                System.out.println(count);
            }
        }
    }
}
