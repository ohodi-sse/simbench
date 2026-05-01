import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        scanner.close();
        if ("SSS".equals(next)) {
            System.out.println(0);
        }
        else if ("RRS".equals(next) || "SRR".equals(next)) {
            System.out.println(2);
        }
        else if ("RRR".equals(next)) {
            System.out.println(3);
        }
        else {
            System.out.println(1);
        }
    }
}