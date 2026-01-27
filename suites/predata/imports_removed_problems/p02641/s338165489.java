class Main
{
	static boolean visited[];
	static long dp[][][];
	static long MOD=1000000007L;
	static Hashtable<String , Long>hash=new Hashtable<>();
	public static void main(String args[]) throws java.lang.Exception
	{
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		String h[]=inp.readLine().split(" ");
		String hh[]=new String[0];
		if(Integer.parseInt(h[1])!=0){hh=inp.readLine().split(" ");}
		HashSet<Integer>hash=new HashSet<>();
		for(int i=0;i<hh.length;i++){hash.add(Integer.parseInt(hh[i]));}
		
		int x=Integer.parseInt(h[0]);
		int x1=x;
		int ans=0;
		while(true)
		{
			if(!hash.contains(x1)){ans=x1;break;}
			x1++;
		}
		x1=x-1;
		while(true)
		{
			if(!hash.contains(x1)){if(x-x1<=ans-x){ans=x1;}break;}
			x1--;
		}
		System.out.println(ans);

	}
	static long get(long x, String s, long arr[], int i,int a, int b)
	{
		if(i==s.length()){return x==0?1:2;}
		
		
		if(dp[i][a][b]!=0){return dp[i][a][b];}
		if(s.charAt(i)=='1')
		{
				dp[i][a][b]=Math.max(get(x^arr[i],s,arr,i+1,a,b+1),get(x,s,arr,i+1,a,b));
		}
		else{
		dp[i][a][b]=Math.min(get(x^arr[i],s,arr,i+1,a+1,b),get(x,s,arr,i+1,a,b));}
		return dp[i][a][b];
	}

		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 
 
  
 
 
  
 
 
 
  
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	

	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
class Pair
{
	
	long a;
	long b;
	Pair(long f, long h)
	{
		
		a=f;
		b=h;
	}
}