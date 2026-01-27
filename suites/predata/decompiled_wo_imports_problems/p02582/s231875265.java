public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        final int[] array2 = new int[next.length()];
        int n = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                final int[] array3 = array2;
                final int n2 = n;
                ++array3[n2];
            }
            else {
                ++n;
            }
        }
        final Vector coll = new Vector();
        for (int j = 0; j < array2.length; ++j) {
            coll.add(array2[j]);
        }
        System.out.println(Collections.max((Collection<?>)coll));
    }
}