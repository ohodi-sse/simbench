public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        String str = (scanner = new Scanner(System.in)).nextLine();
        scanner.close();
        int n = 0;
        int x = 0;
        while (str.length() > 0) {
            if (str.startsWith("R")) {
                ++n;
            }
            else {
                n = 0;
            }
            if (n > x) {
                x = n;
            }
            final StringBuilder sb;
            if ((sb = new StringBuilder(str)).length() > 0) {
                sb.deleteCharAt(0);
            }
            str = sb.toString();
        }
        System.out.println(x);
    }
    
    private static String removeLeadingZeroes(final String str) {
        final StringBuilder sb;
        if ((sb = new StringBuilder(str)).length() > 0) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}