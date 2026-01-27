public class Main
{
    public static void main(final String[] array) {
        resolve(System.in, System.out);
    }
    
    static void resolve(final InputStream source, final PrintStream printStream) {
        final Scanner scanner = new Scanner(source);
        int max = 0;
        int b = 0;
        final char[] charArray = scanner.next().toCharArray();
        for (int length = charArray.length, i = 0; i < length; ++i) {
            if (charArray[i] == 'R') {
                ++b;
                max = Math.max(max, b);
            }
            else {
                b = 0;
            }
        }
        printStream.println(max);
    }
}