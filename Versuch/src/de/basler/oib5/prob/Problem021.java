package de.basler.oib5.prob;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author F820739
 *
 */


public class Problem021 implements ProEuler{
	
	private static List<Integer> amicables;
	public Problem021(){ 
		amicables = new ArrayList<Integer>();	
		}
	
	

	
	
	public static boolean isAmicable(int n){
        int m  = divisorSum(n);
        return (m != n) && (divisorSum(m) == n);
	}
	

	/**
	 * 
	 * @param n the integer whose divisorSum is being computed
	 * @return for each divisor d1, ...., dm | n , we return d1 + ... + dm
	 */
	private static int divisorSum(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0)
				sum += i;
		}
		return sum;
	}



	@Override
	public String run() {
		for (int i = 1; i < 10_000; i++) {
			if( isAmicable(i)){
				amicables.add(i);
				}
			}
		Integer sum = 0;
		for(Iterator<Integer> ami =  amicables.iterator(); ami.hasNext(); ){
			Integer elem = ami.next();
			sum += elem;
		}
		return sum.toString();
	}
	
	
	
	public static void main(String args[]) {
	      System.out.println(new Problem021().run() );	
	    }
}