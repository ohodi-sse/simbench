public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final char[] charArray = scanner.nextLine().toCharArray();
        int x = 0;
        int n = 0;
        final char[] array2 = charArray;
        for (int length = array2.length, i = 0; i < length; ++i) {
            if (array2[i] == 'R') {
                ++n;
                if (x < n) {
                    x = n;
                }
            }
            else {
                n = 0;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}