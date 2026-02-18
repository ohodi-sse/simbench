final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        int j = 1;
        int x = 0;
        int n = 0;
        while (j != 0) {
            boolean b = true;
            boolean b2 = true;
            int n2 = 1;
            if (nextInt - n > 0) {
                for (int k = 0; k < nextInt2; ++k) {
                    if (nextInt - n == array[k]) {
                        n2 = 0;
                        b2 = false;
                    }
                }
            }
            if (n2 == 0) {
                n2 = 1;
                for (int l = 0; l < nextInt2; ++l) {
                    if (nextInt + n == array[l]) {
                        n2 = 0;
                        b = false;
                    }
                }
            }
            if (n2 != 0) {
                if (b2) {
                    x = nextInt - n;
                }
                else if (b) {
                    x = nextInt + n;
                }
                j = 0;
            }
            ++n;
        }
        System.out.println(x);
    }
}