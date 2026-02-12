import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        final String line;
        if ((line = new BufferedReader(new InputStreamReader(System.in)).readLine()).contains("RRR")) {
            System.out.println("3");
            return;
        }
        if (line.contains("RR")) {
            System.out.println("2");
            return;
        }
        if (line.contains("R")) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}
