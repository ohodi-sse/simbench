public class Main{

	public static void main(String[] args) {
		

		Scanner sc=new Scanner(System.in);
		BigDecimal A=new BigDecimal(sc.nextLong());
		BigDecimal B=new BigDecimal(sc.next());
		
		BigDecimal result=A.multiply(B);
		BigDecimal BigResult=result.setScale(0,RoundingMode.DOWN);
		System.out.println(BigResult);
	
	}

}