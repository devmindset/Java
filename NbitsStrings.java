import java.util.Arrays;

public class NbitsStrings {
	int[] arrA;

	public NbitsStrings(int n) {
		arrA = new int[n];
	}

	public void nBits(int n) {
		if (n <= 0) {
			System.out.println("%%%%%%%%%%%%%%"+Arrays.toString(arrA));
		} else {
			
			arrA[n - 1] = 0;
			System.out.println("Be --"+n+" = "+Arrays.toString(arrA));
			nBits(n - 1);
			//System.out.println(n+" = "+Arrays.toString(arrA));
			arrA[n - 1] = 1;
			System.out.println("Ae --"+n+" = "+Arrays.toString(arrA));
			nBits(n - 1);
			
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		int n = 3;
		NbitsStrings i = new NbitsStrings(n);
		i.nBits(n);
	}
}