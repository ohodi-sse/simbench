public final class Main
{
    private static void main$3231c38a() {
        final String next;
        if ((next = new Scanner(System.in).next()).length() != 3) {
            System.exit(0);
        }
        if (next.equals("RRR")) {
            System.out.println("3");
            System.exit(0);
        }
        if (next.equals("RRS") || next.equals("SRR")) {
            System.out.println("2");
            System.exit(0);
        }
        if (next.equals("SSS")) {
            System.out.println("0");
            System.exit(0);
            return;
        }
        System.out.println("1");
    }
}