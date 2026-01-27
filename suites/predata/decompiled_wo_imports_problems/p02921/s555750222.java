public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final char[] charArray = scanner.next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            x = ((charArray[i] == charArray2[i]) ? (x + 1) : x);
        }
        System.out.println(x);
    }
}