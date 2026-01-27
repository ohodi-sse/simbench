public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int targetNumber = sc.nextInt();  
		int max_dividing = 0; 
		int max_number = 1; 


		for(int i = 1; i <= targetNumber; i++) { 
			int ExTargetNumber = i;
			int manyOfdividing = 0; 
			while(true) { 
				if(ExTargetNumber % 2 == 0 && ExTargetNumber >0){
					ExTargetNumber = ExTargetNumber / 2;
					manyOfdividing++;
				}else {
					if(max_dividing < manyOfdividing) {
						max_dividing = manyOfdividing;
						max_number = i;
					}
					break;
				}
			}
		}
		System.out.println(max_number);
	}
}