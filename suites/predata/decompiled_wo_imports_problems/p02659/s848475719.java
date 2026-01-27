public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final char[] charArray = scanner.next().toCharArray();
        System.out.println(nextLong * ((charArray[0] - '0') * 100 + (charArray[2] - '0') * 10 + (charArray[3] - '0')) / 100L);
    }
}