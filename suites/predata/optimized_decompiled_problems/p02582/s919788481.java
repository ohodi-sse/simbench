import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static Scanner sc;
    
    private static void main$3231c38a() {
        final Matcher matcher;
        if ((matcher = Pattern.compile("R+").matcher(Main.sc.next())).find()) {
            System.out.println(matcher.group().length());
            return;
        }
        System.out.println(0);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}
