public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        int x = 0;
        if (next.substring(0, 1).equals(next2.substring(0, 1))) {
            ++x;
        }
        if (next.substring(1, 2).equals(next2.substring(1, 2))) {
            ++x;
        }
        if (next.substring(2, 3).equals(next2.substring(2, 3))) {
            ++x;
        }
        System.out.println(x);
    }
    
    private static int countSwapBabbleSort(final int[] array) {
        int n = 0;
        final int[] array2 = new int[array.length + 1];
        for (int i = 0; i < array.length; ++i) {
            final int n2 = n;
            final int n3 = i;
            final int[] array3 = array2;
            int j = array[i];
            final int[] array4 = array3;
            int n4 = 0;
            while (j > 0) {
                n4 += array4[j];
                final int n5 = j;
                j = n5 - (n5 & -j);
            }
            n = n2 + (n3 - n4);
            final int[] array5 = array2;
            int k = array[i];
            int n7;
            for (int[] array6 = array5; k < array6.length; k = n7 + (n7 & -k)) {
                final int[] array7 = array6;
                final int n6 = k;
                ++array7[n6];
                n7 = k;
            }
        }
        return n;
    }
    
    private static void add$1c96c31d(final int[] array, int i) {
        while (i < array.length) {
            final int n = i;
            ++array[n];
            final int n2 = i;
            i = n2 + (n2 & -i);
        }
    }
    
    private static int sum(final int[] array, int i) {
        int n = 0;
        while (i > 0) {
            n += array[i];
            final int n2 = i;
            i = n2 - (n2 & -i);
        }
        return n;
    }
    
    private static void log(final String x) {
        System.out.println(x);
    }
    
    private static void log(final int x) {
        System.out.println(x);
    }
    
    private static void log(final double x) {
        System.out.println(x);
    }
}