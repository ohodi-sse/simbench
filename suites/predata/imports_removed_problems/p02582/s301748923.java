public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String S = scan.next();
		String[] Sarray = S.split("");






		int count = 0;
		if(!(Sarray[0].equals("R")) && !(Sarray[1].equals("R")) && !(Sarray[2].equals("R"))){
			count = 0;
			System.out.println(count);
			return;
		}
		if(Sarray[0].equals("R") && Sarray[1].equals("R") && Sarray[2].equals("R")){
			count = 3;
			System.out.println(count);
			return;
		}
		if(Sarray[0].equals("R") && Sarray[1].equals("R")){
			count = 2;
			System.out.println(count);
			return;
		}
		if(Sarray[1].equals("R") && Sarray[2].equals("R")){
			count = 2;
			System.out.println(count);
			return;
		}

		if(Sarray[0].equals("R")){
			count = 1;
			System.out.println(count);
			return;
		}
		if(Sarray[1].equals("R")){
			count = 1;
			System.out.println(count);
			return;
		}
		if(Sarray[2].equals("R")){
			count = 1;
			System.out.println(count);
			return;
		}



		System.out.println(count);
	}

}