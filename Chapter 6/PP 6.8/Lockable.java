
public interface Lockable 
{
	public void setKey(int newKey); //Abstract methods that are implemented in 'Coin' class
	public void lock(int newKey);
	public void unlock(int newKey);
	public boolean locked();
}
