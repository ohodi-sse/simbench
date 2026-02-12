import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        final String regex = "RRR";
        final String regex2 = "RR";
        final String regex3 = "R";
        final Pattern compile = Pattern.compile(regex);
        final Pattern compile2 = Pattern.compile(regex2);
        final Pattern compile3 = Pattern.compile(regex3);
        final Matcher matcher = compile.matcher(next);
        final Matcher matcher2 = compile2.matcher(next);
        final Matcher matcher3 = compile3.matcher(next);
        if (matcher.find()) {
            System.out.println("3");
            return;
        }
        if (matcher2.find()) {
            System.out.println("2");
            return;
        }
        if (matcher3.find()) {
            System.out.println("1");
            return;
        }
        System.out.println("0");
    }
}
