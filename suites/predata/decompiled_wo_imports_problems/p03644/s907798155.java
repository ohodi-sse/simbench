public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int int1 = Integer.parseInt((scanner = new Scanner(System.in)).next());
        final int[] array = { 64, 32, 16, 8, 4, 2, 1 };
        for (int i = 0; i < 7; ++i) {
            if (int1 >= array[i]) {
                System.out.println(array[i]);
                break;
            }
        }
        scanner.close();
    }
}