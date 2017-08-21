package de.basler.oib5.prob;

import java.math.BigInteger;

public class problem020 implements ProEuler {

	
	public BigInteger factorial(int n) {
		if(n<0)
			throw new IllegalArgumentException("Function factorial called with negative argument");
		BigInteger prod = BigInteger.ONE;
		for(int i = 2; i <= n; i++)
			prod = prod.multiply(BigInteger.valueOf(i));
		return prod;
	}

	private int digitSum(BigInteger n) {
		String tmp = n.toString();
		int ln = tmp.length();
		int sum = 0;
		for (int i = 0; i < ln; i++) {
			int digit = (int) tmp.charAt(i) - '0';
			sum += digit;
		}
		return sum;
	}
	
	@Override
	public String run() {
		BigInteger oneHundredFactorielle = factorial(100);
		Integer ans = new Integer(digitSum(oneHundredFactorielle));
		
		return ans.toString();
	}
	
	

	public static void main(String[] args) {
		System.out.println(new problem020().run());
	}
}
