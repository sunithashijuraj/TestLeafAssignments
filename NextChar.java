package week1.day3;

public class NextChar {

	public static void main(String[] args) {
		String txt = "A1B2C3";
		
		
		for (int i =0; i < txt.length();i++) {
			char charAtValue = (char) (txt.charAt(i)+1);
			System.out.print(charAtValue);
		}

	}

}
