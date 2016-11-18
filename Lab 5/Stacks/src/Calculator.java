import java.util.Scanner;

public class Calculator 
{

	public static void main(String[] args) throws SyntaxErrorException 
	{
		LIFOStack<Integer> stack = new ArrayStack2<Integer>();
		InfixToPostfixGenerator inToPost = new InfixToPostfixGenerator();
		PostfixEvaluator evaluator = new PostfixEvaluator();
		
		Scanner scan = new Scanner(System.in);
		String expression = "";
		boolean valid = false;
		
		while (!valid)
		{
			valid = true;
			
			System.out.print("Input expression: ");
			expression = scan.nextLine();
			
			for (int i = 0; i < expression.length(); i++)
			{
				if ((expression.charAt(i) < '*' && expression.charAt(i) > ' ') || expression.charAt(i) == ','
				|| expression.charAt(i) == '.' || (expression.charAt(i) < '^' && expression.charAt(i) > '9') 
				|| expression.charAt(i) > '^' || expression.charAt(i) < ' ')
				{
					valid = false;
				}
			}
			
			if (!valid)
			{
				System.out.println("Expression is not valid!\n");
			}
		}
		
		boolean correct = false;
		
		String postfix = null;
		try {
			postfix = inToPost.convert(expression);
		} catch (SyntaxErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		int result;
		result = evaluator.eval(postfix);
		System.out.println(result);				
	}

}
