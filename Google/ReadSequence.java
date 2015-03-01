public class ReadSequence{
	public static void main(String [] args){
		int n=Integer.parseInt(args[0]);
		for (int i=0;i<n;i++){
			System.out.println(getNthInSequence(i+1));
		}
	}

	public static String getNthInSequence(int n){
		String toReturn="";
		
		if (n>=1){
			toReturn="1";
			for (int i=0;i<n-1;i++){
				toReturn=getNextInSequence(toReturn);
			}
		}
		return toReturn;

	}

	private static String getNextInSequence(String str){
		StringBuilder str_b=new StringBuilder();
		int count=0;
		char currChar='a';
		for (int i=0;i<str.length();i++){
			if (i==0) {currChar=str.charAt(i);}
			char newChar=str.charAt(i);
			if (newChar!=currChar){
				str_b.append(count);
				str_b.append(currChar);
				currChar=newChar;
				count=0;
			}
			count++;
		}
		str_b.append(count);
		str_b.append(currChar);		
		return str_b.toString();
	}

}