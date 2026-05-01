import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        scanner.close();
        int n;
        for (n = 0; i > 1; i /= 2, ++n) {}
        System.out.println(1 << n);
    }
}