import java.util.ArrayList;
import java.util.Scanner;

public class Day11Challenge12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 8; i++) {
            String name = sc.nextLine();
            String[] items = sc.nextLine().substring(18).split(", ");
            String operation = sc.nextLine();
            int test = Integer.parseInt(sc.nextLine().substring(21));
            int d1 = Integer.parseInt(sc.nextLine().substring(29));
            int d2 = Integer.parseInt(sc.nextLine().substring(30));
            Monkey[] temp = new Monkey[Monkey.all.length + 1];
            for (int j = 0; j < Monkey.all.length; j++) {
                temp[j] = Monkey.all[j];
            }
            temp[Monkey.all.length] = new Monkey(items, operation, test, d1, d2, name);
            Monkey.all = temp;
            sc.nextLine();
        }
        for (Monkey monkey: Monkey.all) {
            Monkey.LCM *= monkey.test;
        }
        System.out.println("test");
        for (int i = 0; i < 10_000; i++) {
            for (Monkey monkey: Monkey.all) {
                monkey.inspect();
            }
        }
        System.out.println("done");
        for (Monkey monkey: Monkey.all) {
            System.out.println(monkey.inspections);
        }
        long max1 = 0;
        long max2 = 0;
        for (Monkey monkey: Monkey.all) {
            if (monkey.inspections > max1){
                max2 = max1;
                max1 = monkey.inspections;
            } else if (monkey.inspections > max2){
                max2 = monkey.inspections;
            }
        }
        System.out.println("Output: " + (max1 * max2));
    }
}
class Monkey{
    public static Monkey[] all = new Monkey[0];
    public static int LCM = 1;
    public ArrayList<Long> items = new ArrayList<>();
    public String operation;
    public int test;
    public int destination1;
    public int destination2;
    public String name;
    public int inspections = 0;
    public Monkey(String[] ite, String ope, int tes, int d1, int d2, String nam){
        for (String str: ite) {
            items.add(Long.parseLong(str));
        }
        operation = ope;
        test = tes;
        destination1 = d1;
        destination2 = d2;
        name = nam;
    }
    public void inspect(){
        for (int i = 0; i < items.size(); i++) {
            inspections++;
            long temp = items.get(i);
            if (operation.charAt(23) == '+'){
                temp += Integer.parseInt(operation.substring(25));
            } else if (operation.charAt(25) == 'o'){
                temp *= temp;
            } else {
                temp *= Integer.parseInt(operation.substring(25));
            }
            temp %= LCM;
            if (temp % test == 0){
                Monkey.all[destination1].items.add(temp);
            } else {
                Monkey.all[destination2].items.add(temp);
            }
        }
        items.clear();
    }
}