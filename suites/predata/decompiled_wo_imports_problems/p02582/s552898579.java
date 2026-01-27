public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        scanner.close();
        final char char1 = next.charAt(0);
        final char char2 = next.charAt(1);
        final char char3 = next.charAt(2);
        int n = 0;
        if (char1 == 'R') {
            ++n;
        }
        if (char2 == 'R') {
            ++n;
        }
        if (char3 == 'R') {
            ++n;
        }
        if (n == 3) {
            print(3);
            return;
        }
        if (n == 2) {
            if (char1 == 'R' && char3 == 'R') {
                print(1);
                return;
            }
            print(2);
        }
        else {
            if (n == 1) {
                print(1);
                return;
            }
            print(0);
        }
    }
    
    public static void print(final Object x) {
        System.out.println(x);
    }
}