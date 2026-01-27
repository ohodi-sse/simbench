public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * Long.valueOf(scanner.next().replace(".", "")) / 100L);
    }
}