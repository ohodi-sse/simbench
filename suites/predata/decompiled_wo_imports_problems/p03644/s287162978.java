public final class Main
{
    private static void main$3231c38a() {
        int i;
        if ((i = new Scanner(System.in).nextInt()) == 1) {
            System.out.println(1);
            System.exit(0);
        }
        int n = 0;
        int n2 = 0;
        int x = 0;
        while (i > 0) {
            if (i % 2 == 0) {
                for (int n3 = i; n3 % 2 == 0; n3 /= 2, ++n2) {}
                if (n < n2) {
                    x = i;
                    n = n2;
                }
            }
            n2 = 0;
            --i;
        }
        System.out.println(x);
    }
}