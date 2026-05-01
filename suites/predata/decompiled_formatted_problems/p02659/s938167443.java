import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final int int1 = Integer.parseInt(clean(scanner.nextLine()));
        scanner.close();
        System.out.println(nextLong * int1 / 100L);
    }
    
    private static String clean(final String s) {
        final int length = s.length();
        String s2 = "";
        for (int i = 0; i < length; ++i) {
            final char char1 = s.charAt(i);
            if (char1 != ' ' && char1 != '.') {
                s2 += char1;
            }
        }
        return s2;
    }
}