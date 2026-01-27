public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int int1 = Integer.parseInt(scanner.next());
        scanner.close();
        final int[] array2 = new int[int1];
        for (int i = 0; i < int1; ++i) {
            array2[i] = i + 1;
        }
        int n = 0;
        int n2 = 0;
        int x = 0;
        for (int j = 0; j < int1; ++j) {
            if (int1 == 1) {
                x = 1;
                break;
            }
            for (int n3 = array2[j]; n3 % 2 == 0; n3 /= 2, ++n) {}
            if (n2 < n) {
                n2 = n;
                x = array2[j];
            }
            n = 0;
        }
        System.out.println(x);
    }
}