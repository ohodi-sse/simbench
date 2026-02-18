public final class Main
{
    private static void main$3231c38a() {
        final String next;
        int x;
        if ((next = new Scanner(System.in).next()).equals("RRR")) {
            x = 3;
        }
        else if (next.equals("RRS") || next.equals("SRR")) {
            x = 2;
        }
        else if (next.equals("SSS")) {
            x = 0;
        }
        else {
            x = 1;
        }
        System.out.println(x);
    }
}