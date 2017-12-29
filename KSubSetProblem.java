
public class KSubSetProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int set[] = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		int[] sol= new int[set.length];
		find(set, 0, 0, sum,sol);
	}

	public static void find(int[] A, int currSum, int index, int sum,
			int[] solution) {
		if (currSum == sum) {
			System.out.println("\nSum found");
			for (int i = 0; i < solution.length; i++) {
				if (solution[i] == 1) {
					System.out.print("  " + A[i]);
				}
			}

		} else if (index == A.length) {
			return;
		} else {
			solution[index] = 1;// select the element
			currSum += A[index];
			System.out.println("B -"+currSum +" - index :"+index);
			find(A, currSum, index + 1, sum, solution);
			currSum -= A[index];
			System.out.println("A -"+currSum +" - index :"+index);
			solution[index] = 0;// do not select the element
			find(A, currSum, index + 1, sum, solution);
		}
		return;
	}
}
