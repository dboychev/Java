
public class Bookshelf 
{

	public static void main(String[] args) 
	{
		Book book1, book2, book3;
		
		book1 = new Book("Don Quixote", "Miguel de Cervantes", "Usborne", 1615);
		book2 = new Book("Pride and Prejudice", "Jane Austen", "Modern Library", 1813);
		book3 = new Book("Hamlet", "William Shakespeare", "Folger", 1892);
		
		System.out.println(book1.toString());
		System.out.println(book2.toString());		
		System.out.println(book3.toString());
		
		book1.setTitle("The Giver");		
		book1.setAuthor("Lois Lowry");
		book1.setCopyrightDate(1993);
		
		book2.setTitle("The Book Thief");
		book2.setAuthor("Markus Zusak");
		book2.setCopyrightDate(1956);
		
		System.out.println(book1.toString());
		System.out.println(book2.toString());		
		System.out.println(book3.toString());
		
	}

}
