public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        final String[] array2 = new String[3];
        final String[] array3 = new String[3];
        final String[] split = scanner.next().split("");
        final String[] split2 = scanner.next().split("");
        for (int i = 0; i < 3; ++i) {
            if (split[i].equals(split2[i])) {
                ++x;
            }
        }
        System.out.println(x);
    }
}