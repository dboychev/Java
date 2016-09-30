import java.io.*;
import java.util.*;

public class FileUtil
{
  public static String[] load(String fileName)
  {
    try
    {
      BufferedReader in = new BufferedReader(new FileReader(fileName));
      String line = in.readLine();
      ArrayList<String> lines = new ArrayList<String>();
      while (line != null)
      {
        lines.add(line);
        line = in.readLine();
      }
      in.close();
      String[] array = new String[lines.size()];
      for (int i = 0; i < lines.size(); i++)
        array[i] = lines.get(i);
      return array;
    }
    catch(IOException e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public static void save(String fileName, String[] lines)
  {
    try
    {
      PrintWriter out = new PrintWriter(new FileWriter(fileName));
      for (String line : lines)
        out.println(line);
      out.close();
    }
    catch(IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}