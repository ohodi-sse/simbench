final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        final String next;
        if ((next = scanner.next()).equals("SSR") || next.equals("SRS") || next.equals("RSS") || next.equals("RSR")) {
            x = 1;
        }
        else if (next.equals("RRS") || next.equals("SRR")) {
            x = 2;
        }
        else if (next.equals("RRR")) {
            x = 3;
        }
        else if (next.equals("SSS")) {
            x = 0;
        }
        System.out.println(x);
    }
}