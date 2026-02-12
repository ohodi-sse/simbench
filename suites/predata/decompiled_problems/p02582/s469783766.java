import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        System.out.println(new Solver().solve(new Scanner(System.in).next()));
    }
}
// 
// Decompiled by Procyon v0.6.0
// 

class Solver
{
    public int solve(final String s) {
        int max = 0;
        int n = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'R') {
                max = Math.max(max, i - n + 1);
            }
            else {
                n = i + 1;
            }
        }
        return max;
    }
}
