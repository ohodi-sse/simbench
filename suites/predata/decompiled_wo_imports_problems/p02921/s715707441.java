public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final char[] array2 = new char[3];
        final char[] array3 = new char[3];
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        int x = 0;
        scanner.close();
        tenki(nextLine, array2);
        tenki(nextLine2, array3);
        for (int i = 0; i < 3; ++i) {
            if (array2[i] == array3[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    public static void tenki(final String s, final char[] array) {
        for (int i = 0; i < 3; ++i) {
            array[i] = s.charAt(i);
        }
    }
}