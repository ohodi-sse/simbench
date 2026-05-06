import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static final Scanner sc;
    
    public static void main(final String[] array) {
        final Matcher matcher = Pattern.compile("R+").matcher(Main.sc.next());
        if (matcher.find()) {
            System.out.println(matcher.group().length());
        }
        else {
            System.out.println(0);
        }
    }
    
    static {
        sc = new Scanner(System.in);
    }
}
