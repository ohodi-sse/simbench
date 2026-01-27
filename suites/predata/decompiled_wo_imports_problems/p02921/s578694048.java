class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (String.valueOf(next.charAt(i)).equals(String.valueOf(next2.charAt(i)))) {
                ++x;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}