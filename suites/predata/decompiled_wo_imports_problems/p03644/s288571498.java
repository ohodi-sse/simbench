public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(solve(scanner.nextInt()));
        scanner.close();
    }
    
    static int solve(final int i) {
        return Integer.highestOneBit(i);
    }
}