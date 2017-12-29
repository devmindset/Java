package bitmanipulation;

public class Xor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//0^0=0,1^1=0,1^0=1,0^1=1
		int[] A = {1,5,6,1,5};
		int x = 0;
		for (int a : A) {
			x = x ^ a;
			System.out.println("x="+x +" a="+a);
		}
		System.out.println(x);
	}

}
