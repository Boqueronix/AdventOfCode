import java.util.Scanner;


public class Day5Challenge2 {
    public static char[] stack1 = new char[0];
    public static char[] stack2 = new char[0];
    public static char[] stack3 = new char[0];
    public static char[] stack4 = new char[0];
    public static char[] stack5 = new char[0];
    public static char[] stack6 = new char[0];
    public static char[] stack7 = new char[0];
    public static char[] stack8 = new char[0];
    public static char[] stack9 = new char[0];
    public static char[][] stacks = {stack1,stack2,stack3,stack4,stack5,stack6,stack7,stack8,stack9};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        while (input.contains("[")){
            int builder = 0;
            for (int i = 0; i < input.length(); i++) {
                if (i % 4 == 1){
                    if (input.charAt(i) != ' ') {
                        stacks[builder] = addToStart(input.charAt(i), stacks[builder]);
                        draw();
                    }
                    builder++;
                }
            }
            input = sc.nextLine();
        }
        System.out.println("\n");
        while (true){
            input = sc.nextLine();
            if (input.startsWith("move")){
                if (input.charAt(6) == ' ') {
                    int from = Integer.parseInt(input.substring(12, 13)) -1;
                    int to = Integer.parseInt(input.substring(17)) -1;
                    int length = Integer.parseInt(input.substring(5, 6));
                    char[] tbm = new char[length];
                    for (int i = stacks[from].length - length; i < stacks[from].length; i++) {
                        tbm[i - stacks[from].length + length] = stacks[from][i];
                    }
                    stacks[to] = addToEnd(tbm, stacks[to]);
                    stacks[from] = removeXFrom(length, stacks[from]);
                    draw();
                } else {
                    int from = Integer.parseInt(input.substring(13, 14)) -1;
                    int to = Integer.parseInt(input.substring(18)) -1;
                    int length = Integer.parseInt(input.substring(5, 7));
                    char[] tbm = new char[length];
                    for (int i = stacks[from].length - length; i < stacks[from].length; i++) {
                        tbm[i - stacks[from].length + length] = stacks[from][i];
                    }
                    stacks[to] = addToEnd(tbm, stacks[to]);
                    stacks[from] = removeXFrom(length, stacks[from]);
                    draw();
                }
                System.out.println("\n");
                for (char[] a: stacks) {
                    if (a.length > 0) {
                        System.out.println(a[a.length-1]);
                    }
                }
            } else {
                for (char[] a: stacks) {
                    System.out.println(a[a.length -1]);
                }
            }
        }
    }
    public static char[] addToStart(char c, char[] a){
        char[] tbr = new char[a.length + 1];
        tbr[0] = c;
        if (a.length != 0) {
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
                tbr[i + 1] = a[i];
            }
        }
        for (char cha: tbr) {
            System.out.println(cha);
        }
        System.out.println("Added");
        return tbr;
    }
    public static char[] addToEnd(char[] c, char[] a){
        char[] tbr = new char[a.length + c.length];
        for (int i = 0; i < a.length ; i++) {
            tbr[i] = a[i];
        }
        for (int i = a.length; i < tbr.length; i++) {
            tbr[i] = c[i - a.length];
        }
        return tbr;
    }
    public static char[] removeXFrom(int x, char[] a){
        char[] tbr = new char[a.length - x];
        System.arraycopy(a, 0, tbr, 0, a.length - x);
        return tbr;
    }
    public static void draw() {
//        StdDraw.pause(2000);
//        StdDraw.clear();
//        for (int i = 0; i < stacks.length; i++) {
//            for (int j = 0; j < stacks[i].length; j++) {
//                StdDraw.text((i+2)/8.0,(j+2)/8.0, String.valueOf(stacks[i][j]));
//            }
//        }
    }
}