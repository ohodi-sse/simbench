public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        scanner.close();
        int x = 0;
        if (next.indexOf("R") >= 0) {
            x = 1;
        }
        if (next.indexOf("RR") >= 0) {
            x = 2;
        }
        if (next.indexOf("RRR") >= 0) {
            x = 3;
        }
        System.out.println(x);
    }
}