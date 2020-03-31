package week1.day1;

public class Android{
	//Declaring String variable
	String deviceName = "Samsung";
	
	//Declaring float variable
	float deviceVersion = 2.56f;
	
	//declaring long variable
	long deviceID = 968940449;
	
	//declaring boolean variable
	boolean isWorking = true;
	
	//declaring int variable
	int yearOfManufacture = 2020;
public static void main(String[] args) {
	
	//creating class instance
	Android androidMobile = new Android();
	
	//print deviceName
	String deviceName2 = androidMobile.deviceName;
	System.out.println(deviceName2);
	
	//print deviceVersion
	float deviceVersion2 = androidMobile.deviceVersion;
	System.out.println(deviceVersion2);
	
	//print deviceID
	long deviceID2 = androidMobile.deviceID;
	System.out.println(deviceID2);
	
	//print working condition
	boolean isWorking2 = androidMobile.isWorking;
	System.out.println(isWorking2);
	
	//print year of manufacture
	int yearOfManufacture2 = androidMobile.yearOfManufacture;
	System.out.println(yearOfManufacture2);
	
}}