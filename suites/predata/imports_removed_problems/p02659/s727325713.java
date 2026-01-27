public class Main {
    public static void main(String[] args) throws FileNotFoundException {



        

    	Scanner sc = new Scanner(System.in);

    	double A = sc.nextDouble();
    	BigDecimal B = BigDecimal.valueOf(sc.nextDouble());
    	

    	BigDecimal times = B.multiply(BigDecimal.valueOf(A));

    	System.out.println(times.longValue());
    }
}