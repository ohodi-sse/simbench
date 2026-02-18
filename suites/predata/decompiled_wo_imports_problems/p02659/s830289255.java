public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String next = scanner.next();
        String s = "";
        for (int i = 0; i < 4; ++i) {
            if (next.charAt(i) != '.') {
                s += next.charAt(i);
            }
        }
        System.out.println(Integer.parseInt(s) * nextLong / 100L);
        scanner.close();
    }
}