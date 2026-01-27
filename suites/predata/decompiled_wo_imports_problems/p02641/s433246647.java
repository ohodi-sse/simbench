public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        System.out.println(Val(nextInt2, nextInt, array2));
    }
    
    public static int Val(final int n, final int n2, final int[] array) {
        if (n == 0) {
            return n2;
        }
        quickSort(array, 0, n - 1);
        int n3 = n2 + 1;
        int n4 = n2;
        int n5 = 0;
        while (true) {
            --n3;
            if (binarySearch(array, 0, n - 1, n3) == -1) {
                return n3;
            }
            if (n5 != 0) {
                ++n4;
                if (binarySearch(array, 0, n - 1, n4) == -1) {
                    return n4;
                }
            }
            n5 = 1;
        }
    }
    
    public static int binarySearch(final int[] array, final int n, final int n2, final int n3) {
        if (n2 < n) {
            return -1;
        }
        final int n4 = n + (n2 - n) / 2;
        if (array[n4] == n3) {
            return n4;
        }
        if (array[n4] > n3) {
            return binarySearch(array, n, n4 - 1, n3);
        }
        return binarySearch(array, n4 + 1, n2, n3);
    }
    
    public static void quickSort(final int[] array, final int n, final int n2) {
        if (n >= n2) {
            return;
        }
        final int n3 = array[(n + n2) / 2];
        int i;
        int n4;
        for (i = n, n4 = n2; i <= n4; ++i, --n4) {
            while (array[i] < n3) {
                ++i;
            }
            while (array[n4] > n3) {
                --n4;
            }
            if (i <= n4) {
                final int n5 = array[i];
                array[i] = array[n4];
                array[n4] = n5;
            }
        }
        quickSort(array, n, n4);
        quickSort(array, i, n2);
    }
}