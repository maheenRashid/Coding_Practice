public class UralSteaks{
	public static void main(String [] args){
		int n=Integer.parseInt(args[0]);
		int k=Integer.parseInt(args[1]);
		int time_taken;
		if (n<=k){
			time_taken=2;
		}
		else{
			int rem=n%k;
			int simple=n/k;
			int rem_time;
			if ((float)rem>(float)k/2.0)
				rem_time=2;
			else
				rem_time=1;
			time_taken=simple*2+rem_time;
		}

		System.out.println(n+" "+k);
		System.out.println(time_taken);
	}

}