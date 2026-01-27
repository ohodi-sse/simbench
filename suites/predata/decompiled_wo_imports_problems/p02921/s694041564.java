class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        final String substring = next.substring(0, 1);
        final String substring2 = next.substring(1, 2);
        final String substring3 = next.substring(2, 3);
        final String substring4 = next2.substring(0, 1);
        final String substring5 = next2.substring(1, 2);
        final String substring6 = next2.substring(2, 3);
        int x = 0;
        if (substring.equals(substring4)) {
            ++x;
        }
        else {
            x += 0;
        }
        if (substring2.equals(substring5)) {
            ++x;
        }
        else {
            x += 0;
        }
        if (substring3.equals(substring6)) {
            ++x;
        }
        else {
            x += 0;
        }
        System.out.println(x);
    }
}