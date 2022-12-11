import java.util.Scanner;

public class Day10Challenge1 {

    public static int cycles = 0;
    public static int x = 1;
    public static int output = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.equals("")){
            if(input.equals("noop")){
                cycles++;
                store();
            } else if (input.charAt(0) == 'a'){
                cycles++;
                store();
                cycles++;
                store();
                x += Integer.parseInt(input.substring(5));
                System.out.println(x);
            }
            input = sc.nextLine();
        }
        System.out.println(output);
    }
    public static void store(){
        if(cycles == 20 || cycles == 60 || cycles == 100 || cycles == 140 || cycles == 180 || cycles == 220){
            System.out.println("X: " + x + ". Cycles: " + cycles + ", inc: " + (x * cycles));
            output += x * cycles;
        }
    }
}
