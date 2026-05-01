import java.util.Scanner;





public class Main
{
    public static final int MOD = 1000000007;
    
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(Long.parseLong(scanner.next()) * Math.round(Double.parseDouble(scanner.next()) * 100.0) / 100L);
    }
}