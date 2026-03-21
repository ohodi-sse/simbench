import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();
        int x = 0;
        if (nextLine.equals("RRR")) {
            x = 3;
        }
        if (nextLine.equals("RRS")) {
            x = 2;
        }
        if (nextLine.equals("RSS")) {
            x = 1;
        }
        if (nextLine.equals("SSS")) {
            x = 0;
        }
        if (nextLine.equals("SSR")) {
            x = 1;
        }
        if (nextLine.equals("SRR")) {
            x = 2;
        }
        if (nextLine.equals("SRS")) {
            x = 1;
        }
        if (nextLine.equals("RSR")) {
            x = 1;
        }
        System.out.println(x);
        scanner.close();
    }
}