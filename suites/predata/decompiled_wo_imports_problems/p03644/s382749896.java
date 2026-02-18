public final class Main
{
    private static void main$3231c38a() throws Exception {
        final int int1 = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n = 0;
        int x = 1;
        for (int i = 2; i <= int1; ++i) {
            int n2 = i;
            int n3 = 0;
            while (n2 % 2 == 0) {
                ++n3;
                n2 /= 2;
            }
            if (n3 > n) {
                n = n3;
                x = i;
            }
        }
        System.out.println(x);
    }
}