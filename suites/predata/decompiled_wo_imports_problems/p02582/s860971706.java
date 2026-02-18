public final class Main
{
    private static void main$3231c38a() {
        final String next;
        if ((next = new Scanner(System.in).next()).equals("RRR")) {
            System.out.println(3);
            return;
        }
        if (next.contentEquals("SRR") || next.contentEquals("RRS")) {
            System.out.println(2);
            return;
        }
        if (next.equals("SSS")) {
            System.out.println(0);
            return;
        }
        System.out.println(1);
    }
}