public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
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
            System.out.println((Object)3);
            return;
        }
        if (n == 2) {
            if (char1 == 'R' && char3 == 'R') {
                System.out.println((Object)1);
                return;
            }
            System.out.println((Object)2);
        }
        else {
            if (n == 1) {
                System.out.println((Object)1);
                return;
            }
            System.out.println((Object)0);
        }
    }
    
    private static void print(final Object x) {
        System.out.println(x);
    }
}