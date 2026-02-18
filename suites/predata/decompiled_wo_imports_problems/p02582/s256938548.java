public final class Main
{
    private static void main$3231c38a() {
        final String next;
        int x;
        if ((next = new Scanner(System.in).next()).indexOf("RRR") != -1) {
            x = 3;
        }
        else if (next.indexOf("RR") != -1) {
            x = 2;
        }
        else if (next.indexOf(82) != -1) {
            x = 1;
        }
        else {
            x = 0;
        }
        System.out.println(x);
    }
}