final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        int i = 0;
        for (int j = 0; j < next.length(); ++j) {
            final int index;
            if ((index = j) < next2.length() && next.charAt(j) == next2.charAt(index)) {
                ++i;
            }
        }
        System.out.print(i);
    }
}