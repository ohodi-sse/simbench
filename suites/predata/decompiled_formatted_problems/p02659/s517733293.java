import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * Math.round(scanner.nextDouble() * 100.0) / 100L);
    }
}