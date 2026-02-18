public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int int1 = Integer.parseInt((scanner = new Scanner(System.in)).next());
        int i = 2;
        if (int1 == 1) {
            System.out.println(1);
        }
        else {
            while (i <= int1) {
                i <<= 1;
            }
            System.out.println(i / 2);
        }
        scanner.close();
    }
}