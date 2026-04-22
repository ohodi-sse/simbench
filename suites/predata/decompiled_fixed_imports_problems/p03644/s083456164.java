import java.util.Scanner;

class Main
{
    static final Scanner s;
    
    public static void main(final String[] array) {
        int nextInt;
        int x;
        for (nextInt = Main.s.nextInt(), x = 1; x * 2 <= nextInt; x *= 2) {}
        System.out.println(x);
    }
    
    static {
        s = new Scanner(System.in);
    }
}