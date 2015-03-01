public class Mega{
	
	public static void main (String [] args){
		int k=Integer.parseInt(args[0]);
		int n=Integer.parseInt(args[1]);
		int total=0;
		for (int i=0;i<n;i++){
			total+=Integer.parseInt(args[2+i]);
		}
		int limit=k*n;
		int left=total-limit;
		if (left<0) left=0;
		System.out.println("Stuck in jam: "+left);

	}

}		