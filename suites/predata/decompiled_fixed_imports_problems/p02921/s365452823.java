import java.util.Scanner;

class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        solve(scanner.next(), scanner.next());
    }
    
    static void solve(final String s, final String s2) {
        int x = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == s2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}