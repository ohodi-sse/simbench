public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String[] split = scanner.nextLine().split(" ");
        final int int1 = Integer.parseInt(split[0]);
        final int int2 = Integer.parseInt(split[1]);
        final String[] split2 = scanner.nextLine().split(" ");
        final int[] array2 = new int[102];
        array2[0] = 0;
        for (int i = 0; i < int2; ++i) {
            final int int3 = Integer.parseInt(split2[i]);
            final int[] array3 = array2;
            final int n = int3;
            ++array3[n];
        }
        int min = 101;
        int min2 = 101;
        for (int j = 101; j >= 0; --j) {
            if (array2[j] != 1) {
                min = Math.min(min, Math.abs(int1 - j));
                if (min == Math.abs(int1 - j)) {
                    min2 = Math.min(min2, j);
                }
            }
        }
        System.out.println(min2);
    }
}