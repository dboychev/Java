
public class Coins {

	public static void main(String[] args) 
	{
		//Creating 4 objects, each of them is a coin - 1 BGN, 1 EUR, 1 GBP, 1 USD with different values in BGN
		MonetaryCoin bgn = new MonetaryCoin(1);
		MonetaryCoin eur = new MonetaryCoin(1.96);
		MonetaryCoin gbp = new MonetaryCoin(2.27);
		MonetaryCoin usd = new MonetaryCoin(1.74);

		//Printing the objects
		System.out.println(bgn);
		System.out.println(eur);
		System.out.println(gbp);
		System.out.println(usd);

		//Sum of the objects
		System.out.println("Sum of all coins: " + (bgn.getValue() + eur.getValue() + gbp.getValue() + usd.getValue()));
		
		//Showing that 'flip' method is working on a 'MonetaryCoin' object
		System.out.println(bgn);
		bgn.flip();
		System.out.println(bgn);
		bgn.flip();
		System.out.println(bgn);
		bgn.flip();
		System.out.println(bgn);
		bgn.flip();
		System.out.println(bgn);
	}

}
