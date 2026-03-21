import java.util.Scanner;





public class Main
{
    static long toLong(final double n) {
        return (long)(n * 100.0 + 0.001);
    }
    
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final double nextDouble = scanner.nextDouble();
        scanner.close();
        System.out.println(Math.floorDiv(nextLong * toLong(nextDouble), 100L));
    }
}