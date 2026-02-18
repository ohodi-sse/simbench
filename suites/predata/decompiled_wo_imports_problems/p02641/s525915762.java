public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String[] split;
        final int int1 = Integer.parseInt((split = (scanner = new Scanner(System.in)).nextLine().split(" "))[0]);
        final int int2 = Integer.parseInt(split[1]);
        final String[] split2 = scanner.nextLine().split(" ");
        final int[] array;
        (array = new int[102])[0] = 0;
        for (int i = 0; i < int2; ++i) {
            final int int3 = Integer.parseInt(split2[i]);
            final int[] array2 = array;
            final int n = int3;
            ++array2[n];
        }
        int min = 101;
        int min2 = 101;
        for (int j = 101; j >= 0; --j) {
            if (array[j] != 1 && (min = Math.min(min, Math.abs(int1 - j))) == Math.abs(int1 - j)) {
                min2 = Math.min(min2, j);
            }
        }
        System.out.println(min2);
    }
}