final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        int x = 0;
        for (int n = 0; n < 3 && (next.charAt(n) == 'S' || next.charAt(n) == 'C' || next.charAt(n) == 'R') && (next2.charAt(n) == 'S' || next2.charAt(n) == 'C' || next2.charAt(n) == 'R'); ++n) {
            if (next.charAt(n) == next2.charAt(n)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}