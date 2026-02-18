public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        int i = Integer.parseInt((scanner = new Scanner(System.in)).next());
        int n = 0;
        int x = 0;
        while (i > 0) {
            int n2 = i;
            int n3 = 0;
            while (n2 % 2 == 0) {
                ++n3;
                n2 /= 2;
            }
            if (n3 >= n) {
                x = i;
                n = n3;
            }
            --i;
        }
        System.out.println(x);
        scanner.close();
    }
}