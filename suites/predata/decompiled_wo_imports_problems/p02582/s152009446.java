public final class Main
{
    private static void main$3231c38a() {
        final String next;
        if ((next = new Scanner(System.in).next()).equals("RRR")) {
            System.out.println("3");
            return;
        }
        if (next.contains("RR")) {
            System.out.println("2");
            return;
        }
        if (next.contains("R")) {
            System.out.println("1");
            return;
        }
        System.out.println("0");
    }
}