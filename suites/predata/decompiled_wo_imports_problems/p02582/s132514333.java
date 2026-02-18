public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int x = 0;
        if (next.equals("RRR")) {
            x = 3;
        }
        else if (next.equals("RRS") || next.equals("SRR")) {
            x = 2;
        }
        else if (next.equals("RSS") || next.equals("RSR") || next.equals("SSR") || next.equals("SRS")) {
            x = 1;
        }
        System.out.println(x);
    }
}