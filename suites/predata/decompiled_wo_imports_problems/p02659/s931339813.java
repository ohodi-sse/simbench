public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String next = scanner.next();
        final int[] array2 = { Integer.parseInt(String.valueOf(next.charAt(0))), Integer.parseInt(String.valueOf(next.charAt(2))), Integer.parseInt(String.valueOf(next.charAt(3))) };
        final long n = nextLong * array2[0];
        final long n2 = nextLong * array2[1];
        final long n3 = nextLong * array2[2];
        System.out.println(n + n2 / 10L + n3 / 100L + (n2 % 10L * 10L + n3 % 100L) / 100L);
    }
}