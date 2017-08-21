package de.basler.oib5;

public class Client {

	public static long compute1(long n, long m) {
		if (n > 0 && n == m)
			return 1L;
		if (n < 0 || m < 0)
			throw new RuntimeException("noooooo");
		if (n < m)
			throw new RuntimeException("can't be!");
		if (n > 0 && m == 0)
			return 1L;
		return compute1(n, m - 1) + compute1(n - 1, m - 1);
	}

	public static long compute2(int n, int m) {

		long[][] arr = new long[n + 1][n + 1];

		for (int ind = 0; ind <= n; ind++) {
			arr[ind][0] = 1L;
			arr[ind][ind] = 1L;
		}

		for (int nn = 1; nn <= n; nn++) {
			for (int kk = 0; kk <= nn; kk++) {
				arr[nn][kk] = (kk == 0 ? 0 : arr[nn - 1][kk - 1])
						+ (nn == kk ? 0 : arr[nn - 1][kk]);
			}
		}

		return arr[n][m];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println( Client.compute2(2, 2));
		System.out.println( Client.compute1(2, 2));
		System.out.println(Client.compute2(2, 1));
		System.out.println(Client.compute1(2, 1));
		System.out.println(Client.compute2(6, 3));
		System.out.println(Client.compute1(6, 3));
		System.out.println(Client.compute2(4, 2));
		System.out.println(Client.compute1(4, 2));
		System.out.println(Client.compute2(1, 0));
		System.out.println(Client.compute1(1, 0));
		System.out.println(Client.compute2(3, 3));
		System.out.println(Client.compute1(3, 3));
		System.out.println(Client.compute2(60, 3));
		System.out.println(Client.compute1(60, 3));
		System.out.println(Client.compute2(60, 30));
		System.out.println(Client.compute1(60, 30));
	}
}