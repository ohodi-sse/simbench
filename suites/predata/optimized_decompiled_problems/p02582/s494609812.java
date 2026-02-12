import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static BufferedReader br;
    
    private static void main$3231c38a() throws IOException {
        final char c = readC();
        final char c2 = readC();
        final char c3 = readC();
        if (c == 'R' && c2 == 'R' && c3 == 'R') {
            System.out.println("3");
            return;
        }
        if ((c == 'R' && c2 == 'R') || (c3 == 'R' && c2 == 'R')) {
            System.out.println("2");
            return;
        }
        if (c == 'R' || c2 == 'R' || c3 == 'R') {
            System.out.println("1");
            return;
        }
        System.out.println("0");
    }
    
    private static void pr(final String s) {
        System.out.print(s);
    }
    
    private static void pl(final String x) {
        System.out.println(x);
    }
    
    private static String read() {
        try {
            return String.valueOf((char)Main.br.read());
        }
        catch (final IOException ex) {
            ex.printStackTrace();
            return "";
        }
    }
    
    private static char readC() {
        try {
            return (char)Main.br.read();
        }
        catch (final IOException ex) {
            ex.printStackTrace();
            return '\uffff';
        }
    }
    
    private static String readL() {
        try {
            return Main.br.readLine();
        }
        catch (final IOException ex) {
            ex.printStackTrace();
            return "";
        }
    }
    
    private static String readS() {
        final StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                int read;
                while ((read = Main.br.read()) != -1 && (char)read != ' ' && (char)read != '\n') {
                    sb.append((char)read);
                }
                break;
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                continue;
            }
        }
        return sb.toString();
    }
    
    private static int readI() {
        return Integer.parseInt(readS());
    }
    
    private static long readLong() {
        return Long.parseLong(readS());
    }
    
    private static long stol(final String s) {
        return Long.parseLong(s);
    }
    
    private static String[] readSs() {
        return readL().split(" ");
    }
    
    private static int[] readIs() {
        final String[] split;
        final int[] array = new int[(split = readL().split(" ")).length];
        for (int i = 0; i < split.length; ++i) {
            array[i] = Integer.parseInt(split[i]);
        }
        return array;
    }
    
    private static int stoi(final String s) {
        return Integer.parseInt(s);
    }
    
    private static int[] stoi(final String[] array) {
        final int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = Integer.parseInt(array[i]);
        }
        return array2;
    }
    
    private static String itos(final int i) {
        return String.valueOf(i);
    }
    
    private static String[] itos(final int[] array) {
        final String[] array2 = new String[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = String.valueOf(array[i]);
        }
        return array2;
    }
    
    private static String ctos(final char c) {
        return String.valueOf(c);
    }
    
    private static String cstos(final char[] value) {
        return new String(value);
    }
    
    private static char stoc(final String s) {
        return s.charAt(0);
    }
    
    private static char[] stocs(final String s) {
        return s.toCharArray();
    }
    
    static {
        Main.br = new BufferedReader(new InputStreamReader(System.in));
    }
}
