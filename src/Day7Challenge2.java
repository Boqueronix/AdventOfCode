import java.util.Scanner;

public class Day7Challenge2 {
    static DirectoryA big = new DirectoryA("/");
    static DirectoryA open = null;
    static final long MAX = 70_000_000;
    static final long NEEDED = 30_000_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        long total = 0;
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
                            for (AddressB a : open.contents) {
                                if (a.name.equals(input.substring(5))) {
                                    open = (DirectoryA) a;
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
                                open.addToContents(new DirectoryA(name, open));
                            }
                            // add file
                            else {
                                int index = -1;
                                for (int i = 0; i < input.length(); i++) {
                                    if (input.charAt(i) == ' ') {
                                        index = i;
                                    }
                                }
                                open.addToContents(new FileB(input.substring(index + 1), open, Long.parseLong(input.substring(0, index))));
                            }
                            input = sc.nextLine();
                        }
                    }
                }
            } catch (Exception e){
                break;
            }
        }
        for (int i = DirectoryA.all.length - 1; i > -1 ; i--) {
            DirectoryA.all[i].findSize();
            total = big.size;
        }
        System.out.println("Total: " + total);
        long mustRemove = NEEDED + total - MAX;
        long size = Long.MAX_VALUE;
        for (int i = 0; i < DirectoryA.all.length; i++) {
            if (DirectoryA.all[i].size >= mustRemove && DirectoryA.all[i].size < size){
                size = DirectoryA.all[i].size;
            }
        }
        System.out.println("Size to remove: " + size);
    }

}

class AddressB {
    public String name;
    public DirectoryA parent;
    public long size = 0;
    public AddressB(String nam){
        name = nam;
    }
}
class DirectoryA extends AddressB{
    public AddressB[] contents;
    public static DirectoryA[] all = new DirectoryA[0];
    public DirectoryA(String nam, DirectoryA par){
        super(nam);
        parent = par;
        contents = new AddressB[0];
        DirectoryA[] temp = new DirectoryA[all.length + 1];
        for (int i = 0; i < all.length; i++) {
            temp[i] = all[i];
        }
        temp[all.length] = this;
        all = temp;
    }
    public DirectoryA(String nam) {
        super(nam);
        contents = new AddressB[0];
        DirectoryA[] temp = new DirectoryA[all.length + 1];
        for (int i = 0; i < all.length; i++) {
            temp[i] = all[i];
        }
        temp[all.length] = this;
        all = temp;
    }
    public void addToContents(AddressB a){
        AddressB[] temp = new AddressB[contents.length + 1];
        for (int i = 0; i < contents.length; i++) {
            temp[i] = contents[i];
        }
        temp[contents.length] = a;
        contents = temp;
    }

    public void findSize() {
        long sum = 0;
        for (AddressB a: contents) {
            sum += a.size;
        }
        size = sum;
    }
}

class FileB extends AddressB{
    public FileB(String nam, DirectoryA par, long siz){
        super(nam);
        parent = par;
        size = siz;
    }
}