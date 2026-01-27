public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

   String nyuA=sc.nextLine();
  
 
  


int n=Integer.parseInt(nyuA);



int max=0;
int res=0;
for(int i=1;i<=n;i++){
int temp=i;
int count=0;
while(true){
if(temp%2!=0){


if(count>max){
max=count;
res=i;

}
break;
}
temp/=2;
count++;

}

}

if(res==0)res=1;

System.out.println(res);






	}
}