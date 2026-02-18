public final class Main
{
    private static void main$3231c38a() {
        final String next;
        if ((next = new Scanner(System.in).next()).equalsIgnoreCase("SRS") || next.equalsIgnoreCase("SSR") || next.equalsIgnoreCase("RSS") || next.equalsIgnoreCase("RSR")) {
            System.out.println(1);
            return;
        }
        if (!next.contains("R")) {
            System.out.println(0);
            return;
        }
        if (next.equalsIgnoreCase("RRR")) {
            System.out.println(3);
            return;
        }
        System.out.println(2);
    }
}