package de.basler.oib5.prob;

/**
 * 
 * @author F820739 Problem description: write a program that generates the next
 *         (in the lexicographically ordering) permutation. We are given a start
 *         sequence; we shall apply the algorithm one million times. The array
 *         coming from this permutation is the answer.
 */
public class problem024 implements ProEuler {
	/**
	 * 
	 * @param a
	 *            array of integers. These are our digits we allow to be
	 *            permuted. Doublettes are allowed
	 * @return true, if the input has a lexicographically bigger permutation.
	 */
	static boolean nextLexicographicalPermuation(int[] arr) {
		int i = arr.length - 1;
		while (i > 0 && (arr[i - 1] >= arr[i]))
			i--;

		// are we already at the (lex ordered) biggest perm?
		if (i <= 0)
			return false;

		int j = arr.length - 1;
		while (arr[j] <= arr[j - 1])
			j--;
		// swap i-1 , j
		int temp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = temp;

		// reverse the suffix array
		j = arr.length - 1;
		while (i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return true;
	}

	@Override
	public String run() {
		// this is the sequence of numbers we are asked to permute
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		for (int i = 0; i < 999999; i++) {
			if (!nextLexicographicalPermuation(array)) {
				throw new AssertionError();
			}
		}
		String ans = "";
		for (int j = 0; j < array.length; j++)
			ans = ans + array[j];
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new problem024().run());
	}
}
