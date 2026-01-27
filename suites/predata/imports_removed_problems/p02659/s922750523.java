public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigDecimal A_big = new BigDecimal(st.nextToken());
        BigDecimal B_big = new BigDecimal(st.nextToken());

        BigDecimal ans = (A_big.multiply(B_big)).setScale(0, RoundingMode.DOWN);
        

        pw.println(ans.toPlainString());
        
        br.close();
        pw.close();
    }
}