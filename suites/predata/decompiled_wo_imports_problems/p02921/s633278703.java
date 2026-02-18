public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (String.valueOf(next.charAt(i)).equals(String.valueOf(next2.charAt(i)))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}