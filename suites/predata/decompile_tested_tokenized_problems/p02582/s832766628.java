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
        final char[] charArray = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
        if (charArray[0] == 'R' && charArray[1] == 'R' && charArray[2] == 'R') {
            System.out.println(3);
        }
        else if ((charArray[0] == 'R' && charArray[1] == 'R') || (charArray[1] == 'R' && charArray[2] == 'R')) {
            System.out.println(2);
        }
        else if (charArray[0] == 'R' || charArray[1] == 'R' || charArray[2] == 'R') {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}
