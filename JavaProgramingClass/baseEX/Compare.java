package baseEX;

public class Compare {
	public static void main(String[] args) {
	String java= "Java";
	String cpp = "C++";
	int res = java.compareTo(cpp);
	if(res == 0)
		System.out.println("the same");
	else if(res <0)
		System.out.println(java + " < " + cpp);
	else
		System.out.println(java + " > " + cpp);
	}
}