public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int int1 = Integer.parseInt((scanner = new Scanner(System.in)).next());
        scanner.close();
        int x = 0;
        for (int i = 0; i <= 7; ++i) {
            if ((int)Math.floor(Math.pow(2.0, i)) > int1) {
                x = (int)Math.floor(Math.pow(2.0, i - 1));
                break;
            }
        }
        System.out.println(x);
    }
}