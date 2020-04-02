package week1.day3;

public class ReverseString {

	public static void main(String[] args) {
		String txt = "Welcome";
		
		int txtLength = txt.length();
		//System.out.println(txtLength);
		
		char[] charArray = txt.toCharArray();
		for (int i=txtLength-1; i>=0; i--) {
		System.out.print(charArray[i]);	
		}

	}

}
