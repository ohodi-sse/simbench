public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int[] array;
        (array = new int[6])[0] = 2;
        for (int i = 1; i < 6; ++i) {
            array[i] = array[i - 1] << 1;
        }
        if (nextInt == 1) {
            System.out.print(1);
        }
        else if (array[5] <= nextInt) {
            System.out.print(array[5]);
        }
        else {
            for (int j = 0; j < 6; ++j) {
                if (nextInt < array[j]) {
                    System.out.print(array[j - 1]);
                    break;
                }
            }
        }
        scanner.close();
    }
}