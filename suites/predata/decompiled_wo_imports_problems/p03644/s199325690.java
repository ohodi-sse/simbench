public class Main
{
    static BufferedReader br;
    
    static int[] inputval() throws Exception {
        final String[] split = Main.br.readLine().trim().split(" ");
        final int[] array = new int[split.length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Integer.parseInt(split[i]);
        }
        return array;
    }
    
    static Integer[] inputvalInteger() throws Exception {
        final String[] split = Main.br.readLine().trim().split(" ");
        final Integer[] array = new Integer[split.length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Integer.parseInt(split[i]);
        }
        return array;
    }
    
    public static void main(final String[] array) throws Exception {
        for (int i = Integer.parseInt(Main.br.readLine().trim()); i > 0; --i) {
            for (int j = i; j > 0; j /= 2) {
                if (j == 1) {
                    System.out.println(i);
                    return;
                }
                if (j % 2 != 0) {
                    break;
                }
            }
        }
    }
    
    static {
        Main.br = new BufferedReader(new InputStreamReader(System.in));
    }
}