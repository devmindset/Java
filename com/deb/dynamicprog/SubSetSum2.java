package com.deb.dynamicprog;

import java.util.*;

public class SubSetSum2 {
	private int number;
	private int sum;
	private LinkedList<Integer> subset;
	private int[] numbers;

	public SubSetSum2(int[] numbers, int number) {
		this.numbers = numbers;
		this.number = number;
		sum = 0;
		subset = new LinkedList<Integer>();
	}

	public void findSubset(int startPoint, int limit) {
		if (sum == number) {
			System.out.println(subset + " :: " + sum);
		} else {
			for (int i = startPoint; i < numbers.length; i++) {
				sum = sum + numbers[i];
				if (sum > limit) {
					sum = sum - numbers[i];
					//break;
					continue;
				}
				subset.add((int) numbers[i]);
				findSubset(i + 1, limit);
				sum = sum - numbers[i];
				subset.removeLast();
			}
		}
	}

	public static void main(String args[]) {
		int[] numbers = {3,1,2};//{ 1, 2, 3, 4, 5, 6 };
		int number = 3;//15;
		Arrays.sort(numbers);
		SubSetSum2 ki = new SubSetSum2(numbers, number);
		ki.findSubset(0, number);
	}
}
