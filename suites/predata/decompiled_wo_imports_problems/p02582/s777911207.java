public final class Main
{
    private static void main$3231c38a() throws IOException {
        final String next = new Scanner(System.in).next();
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            int b = 0;
            if (next.charAt(i) == 'R') {
                for (b = 0; i < 3 && next.charAt(i) == 'R'; ++i, ++b) {}
            }
            max = Math.max(max, b);
        }
        System.out.println(max);
    }
}