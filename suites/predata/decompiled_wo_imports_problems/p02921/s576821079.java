public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        final String[] split = next.split("");
        final String[] split2 = next2.split("");
        int x = 0;
        for (int i = 0; i <= 2; ++i) {
            if (split[i].equals(split2[i])) {
                ++x;
            }
        }
        System.out.println(x);
    }
}