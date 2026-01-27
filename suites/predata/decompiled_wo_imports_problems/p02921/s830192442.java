class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        final String[] split = next.split("");
        final String[] split2 = next2.split("");
        int x = 0;
        if (split[0].equals(split2[0])) {
            ++x;
        }
        if (split[1].equals(split2[1])) {
            ++x;
        }
        if (split[2].equals(split2[2])) {
            ++x;
        }
        System.out.println(x);
    }
}