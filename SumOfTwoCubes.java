import java.math.BigInteger;
import java.util.HashMap;

/*
 *  (From email) Integer n = 562576374032409 is unique in the sense that
n and n+1 are sums of two cubes:
n = 60684^3 + 69734^3, n+1 = 65521^3 + 65522^3
and also n is the taxi-cab number:
n = 60684^3 + 69734^3 = 65340^3 + 65702^3.
Is n the least such number?
Are there larger such numbers?
 */


public class SumOfTwoCubes {

	public static void main(String[] args) {
		generateAll();
		
	}
	
	private static void generateAll() {
		HashMap<BigInteger,Integer> HRN = new HashMap<BigInteger,Integer>();
		
		for (int i=1; i<2500; i++) {
			for (int j=i; j<2500; j++) {
				BigInteger bi = new BigInteger(i+"");
				BigInteger bj = new BigInteger(j+"");
				bi = bi.pow(3);
				bj = bj.pow(3);
				bi = bi.add(bj);
				if (HRN.containsKey(bi)) HRN.put(bi, HRN.get(bi)+1);
				else HRN.put(bi,1);
			}
		}
		
		for (BigInteger b : HRN.keySet()) if (HRN.get(b) > 1) System.out.println(b+" " + HRN.get(b));
		
	}

	public static void main2(String[] args) {
		long N;
		for (int n=1; n<23; n++) {
			N = 4*n*n*n*n*(4*n*n-3) + 6*n*n - 2;
			System.out.print("("+n +")" +" "+N+" = ");
			System.out.print( (2*n*n-n-1) +"^3 + ");
			System.out.print( (2*n*n+n-1) +"^3 " );
			System.out.println("and "+2*n*n+"^3 + " + (2*n*n-1)+"^3 = " + (N+1));
		}
				
	}

}
