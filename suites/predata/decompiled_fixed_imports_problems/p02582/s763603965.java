import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        if (nextLine.equals("RRR")) {
            System.out.println(3);
        }
        else if (nextLine.contains("RR")) {
            System.out.println(2);
        }
        else if (nextLine.contains("R")) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}