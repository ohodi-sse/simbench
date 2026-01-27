public class Main {
     
    	public static void main(String[] args) {
    		
     
    		Scanner scan = new Scanner(System.in);
    		
    		
    		
    		String a = scan.next();
    		String b = scan.next();
    		
    		BigDecimal a1 = new BigDecimal(a);
    		BigDecimal b1 = new BigDecimal(b);
    		
    		BigDecimal answer = a1.multiply(b1);
    		
    		
    		answer = answer.setScale(0, RoundingMode.DOWN);	
    		
    		
    		System.out.println(answer);
    		
    		}
     
    }