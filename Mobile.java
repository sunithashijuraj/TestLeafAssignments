package week1.day1;

public class Mobile {
	
	String mobileModel = "iPhone 10";
	int mobileAge = 2;
	boolean isWorking  = true;
	
public static void main(String[] args) {
	//Creating reference of the class
	Mobile newMob = new Mobile();
	//print mobile model
	String mobileModel2 = newMob.mobileModel;
	System.out.println(mobileModel2);
	//print mobile age
	int mobileAge2 = newMob.mobileAge;
	System.out.println(mobileAge2);
	//print working condition
	boolean isWorking2 = newMob.isWorking;
	System.out.println(isWorking2);
	
}
}
