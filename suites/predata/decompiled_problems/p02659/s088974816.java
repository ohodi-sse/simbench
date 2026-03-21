import java.util.Scanner;





public class Main
{
    public void main(final Scanner scanner) {
        final String string = new Long(scanner.nextLong() * new Long(scanner.next().replace(".", ""))).toString();
        if (string.length() >= 3) {
            System.out.println(string.substring(0, string.length() - 2));
        }
        else {
            System.out.println(0);
        }
    }
    
    public static void main(final String[] array) {
        new Main().main(new Scanner(System.in));
    }
}