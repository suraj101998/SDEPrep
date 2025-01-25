package DSA.Basic.Strings;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class RemoveDuplicatesWords {
    public static void main(String[] args)
	{
		System.out.println("Enter a line of text: ");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		input.close();
		TreeMap<String, Integer> list = new TreeMap<String, Integer>();
		for(String str : s.split(" "))
		{
			if(list.containsKey(str))
			{
				list.put(str, list.get(str)+1);
			}
			else
			{
				list.put(str, 1);
			}
		}
		for(Entry<String, Integer> e: list.entrySet())
		{
			if((int)e.getValue() == 1)
				System.out.println(e.getKey());
		}
	}
}