public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int n = 0;
        int n2 = 0;
        int nextInt;
        int i = nextInt = scanner.nextInt();
        int x = 1;
        int j = 0;
        while (i > 0) {
            if (i % 2 == 0) {
                while (nextInt % 2 == 0) {
                    nextInt /= 2;
                    ++n;
                }
                if (n2 < n) {
                    n2 = n;
                }
                n = 0;
            }
            nextInt = --i;
        }
        while (j < n2) {
            x <<= 1;
            ++j;
        }
        System.out.println(x);
    }
}