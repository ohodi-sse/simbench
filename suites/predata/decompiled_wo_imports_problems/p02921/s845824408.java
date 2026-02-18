public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String nextLine = (scanner = new Scanner(System.in)).nextLine();
        final String nextLine2 = scanner.nextLine();
        int n = 0;
        int x = 0;
        String[] split;
        for (int length = (split = nextLine.split("")).length, i = 0; i < length; ++i) {
            if (split[i].equals(nextLine2.split("")[n])) {
                ++x;
            }
            ++n;
        }
        System.out.println(x);
    }
}