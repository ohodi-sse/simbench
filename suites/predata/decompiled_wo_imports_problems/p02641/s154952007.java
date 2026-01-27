public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final HashMap hashMap = new HashMap();
        final PrintWriter printWriter = new PrintWriter(System.out);
        final int int1 = Integer.parseInt(scanner.next());
        final int int2 = Integer.parseInt(scanner.next());
        final boolean[] a = new boolean[102];
        Arrays.fill(a, true);
        for (int i = 0; i < int2; ++i) {
            a[Integer.parseInt(scanner.next())] = false;
        }
        int n = 0;
        int j = 1;
        while (j != 0) {
            if (a[Math.max(0, int1 - n)]) {
                printWriter.print("" + (int1 - n));
                j = 0;
            }
            else if (a[Math.min(101, int1 + n)]) {
                printWriter.print("" + (int1 + n));
                j = 0;
            }
            ++n;
        }
        scanner.close();
        printWriter.flush();
    }
}