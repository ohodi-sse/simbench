public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        final int n = nextInt2;
        final int n2 = nextInt;
        final int[] array2 = array;
        int n3 = n2;
        final int n4;
        int x;
        if ((n4 = n) == 0) {
            x = n3;
        }
        else {
            quickSort(array2, 0, n4 - 1);
            int n5 = n3 + 1;
            int n6 = 0;
            while (true) {
                --n5;
                if (binarySearch(array2, 0, n4 - 1, n5) == -1) {
                    x = n5;
                    break;
                }
                if (n6 != 0) {
                    ++n3;
                    if (binarySearch(array2, 0, n4 - 1, n3) == -1) {
                        x = n3;
                        break;
                    }
                }
                n6 = 1;
            }
        }
        System.out.println(x);
    }
    
    private static int Val(final int n, int n2, final int[] array) {
        if (n == 0) {
            return n2;
        }
        quickSort(array, 0, n - 1);
        int n3 = n2 + 1;
        int n4 = 0;
        while (true) {
            --n3;
            if (binarySearch(array, 0, n - 1, n3) == -1) {
                return n3;
            }
            if (n4 != 0) {
                ++n2;
                if (binarySearch(array, 0, n - 1, n2) == -1) {
                    return n2;
                }
            }
            n4 = 1;
        }
    }
    
    private static int binarySearch(int[] array, int n, int i, final int n2) {
        while (i >= n) {
            final int n3 = n + (i - n) / 2;
            if (array[n3] == n2) {
                return n3;
            }
            if (array[n3] > n2) {
                final int[] array2 = array;
                final int n4 = n;
                i = n3 - 1;
                n = n4;
                array = array2;
            }
            else {
                final int[] array3 = array;
                n = n3 + 1;
                array = array3;
            }
        }
        return -1;
    }
    
    private static void quickSort(int[] array, int i, final int n) {
        while (i < n) {
            final int n2 = array[(i + n) / 2];
            int j;
            int n3;
            for (j = i, n3 = n; j <= n3; ++j, --n3) {
                while (array[j] < n2) {
                    ++j;
                }
                while (array[n3] > n2) {
                    --n3;
                }
                if (j <= n3) {
                    final int n4 = array[j];
                    array[j] = array[n3];
                    array[n3] = n4;
                }
            }
            quickSort(array, i, n3);
            final int[] array2 = array;
            i = j;
            array = array2;
        }
    }
}