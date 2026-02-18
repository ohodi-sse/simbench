public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String[] split = (scanner = new Scanner(System.in)).next().split("", 0);
        final String[] split2 = scanner.next().split("", 0);
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (split[i].equals(split2[i])) {
                ++x;
            }
        }
        System.out.println(x);
    }
}