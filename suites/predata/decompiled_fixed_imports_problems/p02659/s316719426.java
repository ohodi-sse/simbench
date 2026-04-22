import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    static long n;
    static long m;
    static long ans;
    
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String[] split = bufferedReader.readLine().split(" ");
        Main.n = Long.parseLong(split[0]);
        Main.m = (split[1].charAt(0) - '0') * 100 + (split[1].charAt(2) - '0') * 10 + (split[1].charAt(3) - '0');
        bufferedReader.close();
        printWriter.println(Main.m * Main.n / 100L);
        printWriter.flush();
    }
}