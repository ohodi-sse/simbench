public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int integerX = sc.nextInt();  
		int youso = sc.nextInt();  
		List<Integer> list = new ArrayList<Integer>();  

		
		for(int i=0 ; i<youso ; i++) {
			list.add(sc.nextInt());
		}

		
		if(list.isEmpty() || ! list.contains(integerX)) {
			System.out.println(integerX);
			return;
		}

		
		for(int i=1 ; i<=100 ; i++) {
			if(! list.contains(integerX-i)) {
				System.out.println(integerX-i);
				break;
			}
			else if(! list.contains(integerX+i)) {
				System.out.println(integerX+i);
				break;
			}
		}
		sc.close();
	}
}