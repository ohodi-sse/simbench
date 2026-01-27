public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        if (nextInt >= 64) {
            System.out.println(64);
        }
        else if (nextInt >= 32) {
            System.out.println(32);
        }
        else if (nextInt >= 16) {
            System.out.println(16);
        }
        else if (nextInt >= 8) {
            System.out.println(8);
        }
        else if (nextInt >= 4) {
            System.out.println(4);
        }
        else if (nextInt == 3 || nextInt == 2) {
            System.out.println(2);
        }
        else if (nextInt == 1) {
            System.out.println(1);
        }
    }
}