class Main {

    
    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        String S;
        S = sc.next();
        String T;
        T = sc.next();
        solve(S, T);
    }

    static void solve(String S, String T){
        int ans = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == T.charAt(i)) ans++;
        }
        System.out.println(ans);
    }
}