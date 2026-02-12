import java.io.Reader;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static BufferedReader br;
    
    private static int[] inputval() throws Exception {
        final String[] split;
        final int[] array = new int[(split = Main.br.readLine().trim().split(" ")).length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Integer.parseInt(split[i]);
        }
        return array;
    }
    
    private static Integer[] inputvalInteger() throws Exception {
        final String[] split;
        final Integer[] array = new Integer[(split = Main.br.readLine().trim().split(" ")).length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Integer.parseInt(split[i]);
        }
        return array;
    }
    
    private static void main$3231c38a() throws Exception {
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
