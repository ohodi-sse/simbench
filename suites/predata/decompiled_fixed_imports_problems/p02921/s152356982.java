import java.util.Scanner;

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        do_(scanner);
        scanner.close();
    }
    
    public static void do_(final Scanner scanner) {
        final char[] charArray = scanner.next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}