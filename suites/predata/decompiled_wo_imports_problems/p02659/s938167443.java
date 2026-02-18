final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String nextLine;
        final int length = (nextLine = scanner.nextLine()).length();
        String s = "";
        for (int i = 0; i < length; ++i) {
            final char char1;
            if ((char1 = nextLine.charAt(i)) != ' ' && char1 != '.') {
                s += char1;
            }
        }
        final int int1 = Integer.parseInt(s);
        scanner.close();
        System.out.println(nextLong * int1 / 100L);
    }
    
    private static String clean(final String s) {
        final int length = s.length();
        String s2 = "";
        for (int i = 0; i < length; ++i) {
            final char char1;
            if ((char1 = s.charAt(i)) != ' ' && char1 != '.') {
                s2 += char1;
            }
        }
        return s2;
    }
}