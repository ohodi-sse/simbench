import java.util.Scanner;

public class Main
{
    static void solve() {
        Scanner scanner;
        int n;
        int n2;
        int n3;
        for (scanner = new Scanner(System.in), n = 1, n2 = 2, n3 = 0; 2 * n <= scanner.nextInt(); n *= n2, ++n3) {}
        System.out.println((int)Math.pow(2.0, n3));
        scanner.close();
    }
    
    public static void main(final String[] array) {
        solve();
    }
}