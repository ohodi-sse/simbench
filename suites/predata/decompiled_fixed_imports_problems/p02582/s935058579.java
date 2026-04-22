import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        System.out.println(next.equals("RRR") ? 3 : (next.contains("RR") ? 2 : next.contains("R")));
    }
}