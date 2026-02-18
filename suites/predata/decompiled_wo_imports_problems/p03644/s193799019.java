public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int int1 = Integer.parseInt((scanner = new Scanner(System.in)).next());
        int n = 0;
        int n2 = 0;
        int x = 0;
        for (int i = 1; i <= int1; ++i) {
            for (int j = i; j > 0; j /= 2, ++n) {}
            if (n > n2) {
                n2 = n;
                x = i;
            }
            n = 0;
        }
        final PrintWriter printWriter;
        (printWriter = new PrintWriter(System.out)).println(x);
        printWriter.flush();
        scanner.close();
    }
}