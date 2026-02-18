public final class Main
{
    private static void main$3231c38a() {
        final String next;
        int x;
        if ((next = new Scanner(System.in).next()).matches(".*R{3}.*")) {
            x = 3;
        }
        else if (next.matches(".*R{2}.*")) {
            x = 2;
        }
        else if (next.matches(".*R{1}.*")) {
            x = 1;
        }
        else {
            x = 0;
        }
        System.out.println(x);
    }
}