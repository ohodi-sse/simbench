public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int int1 = Integer.parseInt((scanner = new Scanner(System.in)).next());
        final int int2;
        final int[] a = new int[int2 = Integer.parseInt(scanner.next())];
        for (int i = 0; i < int2; ++i) {
            a[i] = Integer.parseInt(scanner.next());
        }
        Arrays.sort(a);
        int j = 0;
    Label_0064:
        while (j < Integer.MAX_VALUE) {
            boolean b = true;
            for (int k = 0; k < int2; ++k) {
                if (int1 - j == a[k]) {
                    b = false;
                    break;
                }
            }
            if (b) {
                System.out.println(int1 - j);
                return;
            }
            for (int l = 0; l < int2; ++l) {
                if (int1 + j == a[l]) {
                    ++j;
                    continue Label_0064;
                }
            }
            System.out.println(int1 + j);
        }
    }
}