import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws IOException {
        final String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (line.contains("RRR")) {
            System.out.println("3");
        }
        else if (line.contains("RR")) {
            System.out.println("2");
        }
        else if (line.contains("R")) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}
