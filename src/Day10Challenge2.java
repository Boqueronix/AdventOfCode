import java.util.Scanner;
public class Day10Challenge2 {
    public static int cycles = 0;
    public static int x = 1;
    public static String output = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.equals("")){
            if(input.equals("noop")){
                cycles++;
                if (Math.abs(x - ((cycles - 1) % 40)) <= 1){
                    output += "#";
                } else {
                    output += ".";
                }
                System.out.println(x + ", " + ((cycles - 1) % 40 ) + ", " + output);
                store();
            } else if (input.charAt(0) == 'a'){
                cycles++;
                if (Math.abs(x - ((cycles - 1) % 40)) <= 1){
                    output += "#";
                } else {
                    output += ".";
                }
                System.out.println(x + ", " + ((cycles - 1) % 40 ) + ", " + output);
                store();
                cycles++;
                if (Math.abs(x - ((cycles - 1) % 40)) <= 1){
                    output += "#";
                } else {
                    output += ".";
                }
                store();
                System.out.println(x + ", " + (cycles % 40 ) + ", " + output);
                x += Integer.parseInt(input.substring(5));
            }
            input = sc.nextLine();
            System.out.println(output);
        }

    }
    public static void store(){
        if(cycles % 40 == 0){
            output += "\n";
        }
    }
}

