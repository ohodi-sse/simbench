public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        final String[] array2 = new String[next.length()];
        final String[] array3 = new String[next.length()];
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            array2[i] = next.substring(i, i + 1);
        }
        for (int j = 0; j < next2.length(); ++j) {
            array3[j] = next2.substring(j, j + 1);
        }
        for (int k = 0; k < next.length(); ++k) {
            if (array2[k].equals(array3[k])) {
                ++x;
            }
        }
        System.out.println(x);
    }
}