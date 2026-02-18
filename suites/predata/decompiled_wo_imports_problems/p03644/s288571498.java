public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        System.out.println(Integer.highestOneBit((scanner = new Scanner(System.in)).nextInt()));
        scanner.close();
    }
    
    private static int solve(final int i) {
        return Integer.highestOneBit(i);
    }
}