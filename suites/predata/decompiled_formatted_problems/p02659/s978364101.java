import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String next = scanner.next();
        scanner.close();
        final String[] split = next.split("\\.");
        System.out.println(nextLong * Integer.parseInt(split[0] + split[1]) / 100L);
    }
}