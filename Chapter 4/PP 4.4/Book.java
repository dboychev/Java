
public class Book 
{
	private String title;
	private String author;
	private String publisher;
	private int copyrightDate;
	
	public Book(String newTitle, String newAuthor, String newPublisher, int newCopyrightDate)
	{
		setTitle(newTitle);
		setAuthor(newAuthor);
		setPublisher(newPublisher);
		setCopyrightDate(newCopyrightDate);
	}
	
	public void setTitle(String newTitle)
	{
		title = newTitle;
	}
	
	public void setAuthor(String newAuthor)
	{
		author = newAuthor;
	}
	
	public void setPublisher(String newPublisher)
	{
		publisher = newPublisher;
	}
	
	public void setCopyrightDate(int newCopyrightDate)
	{
		copyrightDate = newCopyrightDate;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public String getPublisher()
	{
		return publisher;
	}
	
	public int getCopyrightDate()
	{
		return copyrightDate;
	}
	
	public String toString()
	{
		String description = new String("*** BOOK DESCRIPTION ***\n"
				+ "Title: " + getTitle() + "\n"
				+ "Author: " + getAuthor() + "\n"
				+ "Publisher: " + getPublisher() + "\n"
				+ "Copyright date: " + getCopyrightDate() + "\n");
		
		return description;
	}
	
}
