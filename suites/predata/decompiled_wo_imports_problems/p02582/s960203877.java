final class Main
{
    private static void main$3231c38a() {
        final String next;
        if ((next = new Scanner(System.in).next()).equals("RRR")) {
            System.out.println("3");
            return;
        }
        if (next.equals("RRS") || next.equals("SRR")) {
            System.out.println("2");
            return;
        }
        if (next.equals("RSS") || next.equals("SRS") || next.equals("SSR") || next.equals("RSR")) {
            System.out.println("1");
            return;
        }
        System.out.println("0");
    }
}