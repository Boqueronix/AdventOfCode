import java.util.Scanner;

public class Day7Challenge1 {
    static Directory big = new Directory("/");
    static Directory open = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        long output = 0;
        while (true){
            try {
                //is a command
                if (input.charAt(0) == '$') {
                    // change directory
                    if (input.charAt(2) == 'c') {
                        //start
                        if (input.charAt(5) == '/') {
                            open = big;
                        }
                        // move out
                        else if (input.charAt(5) == '.') {
                            open = open.parent;
                        }
                        //move in to
                        else {
                            for (Address a : open.contents) {
                                if (a.name.equals(input.substring(5))) {
                                    open = (Directory) a;
                                    break;
                                }
                            }
                        }
                        input = sc.nextLine();
                    }
                    //list
                    else if (input.charAt(2) == 'l') {
                        input = sc.nextLine();
                        while (input.charAt(0) != '$') {
                            // add directory
                            if (input.charAt(0) == 'd') {
                                String name = input.substring(4);
                                open.addToContents(new Directory(name, open));
                            }
                            // add file
                            else {
                                int index = -1;
                                for (int i = 0; i < input.length(); i++) {
                                    if (input.charAt(i) == ' ') {
                                        index = i;
                                    }
                                }
                                open.addToContents(new FileA(input.substring(index + 1), open, Long.parseLong(input.substring(0, index))));
                            }
                            input = sc.nextLine();
                        }
                    }
                }
            } catch (Exception e){
                break;
            }
        }
        for (int i = Directory.all.length - 1; i > -1 ; i--) {
            Directory.all[i].findSize();
            if (Directory.all[i].size < 100_000){
                output += Directory.all[i].size;
            }
        }
        System.out.println("Output: " + output);
    }

}

class Address {
    public String name;
    public Directory parent;
    public long size = 0;
    public Address(String nam){
        name = nam;
    }
}
class Directory extends Address{
    public Address[] contents;
    public static Directory[] all = new Directory[0];
    public Directory(String nam, Directory par){
        super(nam);
        parent = par;
        contents = new Address[0];
        Directory[] temp = new Directory[all.length + 1];
        for (int i = 0; i < all.length; i++) {
            temp[i] = all[i];
        }
        temp[all.length] = this;
        all = temp;
    }
    public Directory(String nam) {
        super(nam);
        contents = new Address[0];
        Directory[] temp = new Directory[all.length + 1];
        for (int i = 0; i < all.length; i++) {
            temp[i] = all[i];
        }
        temp[all.length] = this;
        all = temp;
    }
    public void addToContents(Address a){
        Address[] temp = new Address[contents.length + 1];
        for (int i = 0; i < contents.length; i++) {
            temp[i] = contents[i];
        }
        temp[contents.length] = a;
        contents = temp;
    }

    public void findSize() {
        long sum = 0;
        for (Address a: contents) {
            sum += a.size;
        }
        size = sum;
    }
}

class FileA extends Address{
    public FileA(String nam, Directory par, long siz){
        super(nam);
        parent = par;
        size = siz;
    }
}