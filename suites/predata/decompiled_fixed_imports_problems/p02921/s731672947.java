import java.util.Objects;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        switch (true) {
            case 1: {
                P1.p1();
                break;
            }
        }
    }
}







class P1
{
    static void p1() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine(), scanner.nextLine()));
    }
    
    static int calc(final String s, final String s2) {
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (Objects.equals(s.charAt(i), s2.charAt(i))) {
                ++n;
            }
        }
        return n;
    }
}