public class Main
{
    static int[][] numbers;
    
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            final char char1 = next.charAt(i);
            if (char1 == 'R') {
                int b = 1;
                for (int index = i + 1; index < 3 && char1 == next.charAt(index); ++index) {
                    ++b;
                }
                max = Math.max(max, b);
            }
        }
        System.out.println(max);
    }
}