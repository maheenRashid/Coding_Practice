public class SwitchColor{
	
	public static void main(String []args){

		int color=0x01020304;
		int color_changed=changeScheme(color);

		System.out.println(Integer.toHexString(color));
		System.out.println(Integer.toHexString(color_changed));

	}

	public static int changeScheme(int color){
		int r=(color & 0xFF000000 )>>>8;
		int b=(color & 0x0000FF00)<<16;
		int g=(color & 0x00FF0000)>>>8;
		int a=(color & 0x000000FF);
		int new_color=(r|b)|(g|a);
		return new_color;
	}
}