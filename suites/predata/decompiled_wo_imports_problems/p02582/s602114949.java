public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int n = 0;
        if (next.charAt(0) == 'R') {
            ++n;
        }
        if (next.charAt(1) == 'R') {
            n += 2;
        }
        if (next.charAt(2) == 'R') {
            n += 4;
        }
        if (n == 1 || n == 2 || n == 4 || n == 5) {
            System.out.println(1);
            return;
        }
        if (n == 3 || n == 6) {
            System.out.println(2);
            return;
        }
        if (n == 7) {
            System.out.println(3);
            return;
        }
        System.out.println(0);
    }
}