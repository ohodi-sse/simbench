public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        int x = 0;
        if (next.equals("RRR")) {
            x = 3;
        }
        else if (next.equals("RRS") || next.equals("SRR")) {
            x = 2;
        }
        else if (next.equals("RSS") || next.equals("SRS") || next.equals("SSR") || next.equals("RSR")) {
            x = 1;
        }
        else if (next.equals("SSS")) {
            x = 0;
        }
        System.out.println(x);
        scanner.close();
    }
}