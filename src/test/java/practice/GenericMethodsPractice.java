package practice;

public class GenericMethodsPractice {
	
	public static void main(String args[]) { //calling function/caller function
		
		add(10,20);
		
		int sum = addition(20,30);
		System.out.println(sum);
		System.out.println(addition(sum,100));
		
		sub(40,20);
		sub(100,19);
		
		int e = subtraction();
		System.out.println(e);
		
	}
   
	 public static void add(int a , int b) //called function
	 {
		 int c = a+b; //logic
		 System.out.println(c);
	 }
	 
	 public static int addition(int a , int b)
	 {
		 int c = a+b;
		 return c;
	 }
	 
	 public static void sub(int a , int b)
	 {
		 int c = a-b;
		 System.out.println(c);
	 }
	 
	 public static int subtraction()
	 {
		 int a = 20;
		 int b = 18;
		 int c = a-b;
		 return c;
	 }
}
