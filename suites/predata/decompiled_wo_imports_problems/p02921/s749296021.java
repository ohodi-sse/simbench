public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        final String next = scanner.next();
        final String next2 = scanner.next();
        final String[] split = next.split("");
        final String[] split2 = next2.split("");
        for (int i = 0; i < next.length(); ++i) {
            if (split[i].equals(split2[i])) {
                ++x;
            }
        }
        System.out.println(x);
    }
}