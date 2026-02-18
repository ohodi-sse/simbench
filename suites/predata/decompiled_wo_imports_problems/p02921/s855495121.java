public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String nextLine = (scanner = new Scanner(System.in)).nextLine();
        final String nextLine2 = scanner.nextLine();
        final String[] split = nextLine.split("");
        final String[] split2 = nextLine2.split("");
        int x = 0;
        for (int i = 0; i < split.length; ++i) {
            if (split[i].equals(split2[i])) {
                ++x;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}