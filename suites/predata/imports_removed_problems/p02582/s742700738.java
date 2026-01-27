public class Main {
	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine(); 
		sc.close(); 



		int r = 0; 
		int rm = 0; 

		while(S.length() > 0) {
			if(S.startsWith("R")) {
				r += 1; 
			} else {
				r = 0; 
			}
			
			if(r > rm) {rm = r;}
			
			S = removeLeadingZeroes(S);
		}
		System.out.println(rm);
	}

	
	static String removeLeadingZeroes(String s) {
	    StringBuilder sb = new StringBuilder(s);
	    if (sb.length() > 0) {
	        sb.deleteCharAt(0);
	    }
	    return sb.toString();
	}

}