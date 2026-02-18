public final class Main
{
    private static void main$3231c38a() {
        int i;
        final int n = i = Integer.parseInt(new Scanner(System.in).nextLine());
        int n2 = 0;
        do {
            i /= 2;
            ++n2;
        } while (i > 1);
        int x = 1;
        if (i == 1) {
            for (int j = 0; j < n2; ++j) {
                x <<= 1;
            }
        }
        else {
            x = n;
        }
        System.out.println(x);
    }
}