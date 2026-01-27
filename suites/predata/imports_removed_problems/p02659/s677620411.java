/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Varun
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
    StringTokenizer st = new StringTokenizer(br.readLine());
   
     final BigDecimal a = new BigDecimal( st.nextToken() );
    final BigDecimal orig = new BigDecimal( st.nextToken() );
    
    
    
   BigDecimal res = a.multiply(orig);
   System.out.println(res.toBigInteger().longValueExact());
   
   
    
    }
    
}