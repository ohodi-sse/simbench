public final class Main
{
    private static void main$3231c38a() {
        int i = new Scanner(System.in).nextInt();
        int n = 0;
        boolean b = true;
        if (i >= 2) {
            while (i > 0) {
                ++n;
                i /= 2;
            }
        }
        else {
            b = false;
        }
        if (!b) {
            System.out.println(i);
            return;
        }
        System.out.println((int)Math.pow(2.0, n - 1));
    }
}