package de.basler.oib5;

public class Partition {

	public static long partitions(int n) {
		return partitionsFct(n, n);
	}

	public static long partitionsFct(int sum, int highest) {
		
		if ((sum < 0) || (highest < 0))
			return 0L;
		if (highest == 0 || sum == 0)
			return 1L;
//		if (sum == highest)
//			return partitionsFct(sum, highest - 1) + 1L;
		if( sum < highest)
			return 0L;
			
		return partitionsFct(sum - highest, highest)
				+ partitionsFct(sum, highest - 1);
	}
	
	
	public static void main(String[] args){
		//System.out.println("p(0,1) = " + partitionsFct(0, 1));
		//System.out.println("P(3) = " + partitions(3));
		//System.out.println("p(2,4) = " + partitionsFct(2, 4));
		//System.out.println("p(2,2) = " + partitionsFct(2, 2));
		System.out.println("P(4) = " + partitions(4));
		System.out.println("P(5) = " + partitions(5));
	}
}