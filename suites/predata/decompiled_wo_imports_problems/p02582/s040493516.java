public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int x = -1;
        for (int i = next.length(); i >= 0; --i) {
            if (next.matches(String.format(".*R{%d}.*", i))) {
                x = i;
                i = -1;
            }
        }
        System.out.println(x);
    }
}