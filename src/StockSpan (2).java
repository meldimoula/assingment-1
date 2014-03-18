import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.StringIndexOutOfBoundsException;
import java.util.ArrayList;

public class StockSpan
{
	String date[];
	String quote[];

	public static void main(String [] args)
	{
		String s1,s2,s3;
		s1= "-n";
		s2= "-s";
		s3= "-b";
		ArrayList mylist = new ArrayList<String>();

		if (args.length == 2)
		{
			// Location of file to read
			File file = new File(args[1]);
		    int i;
		    try
			{
				Scanner scanner = new Scanner(file);
			    i = 0;
			    while (scanner.hasNextLine())
			    {
					String line = scanner.nextLine();
					mylist.add(line);


			    }
			    String[] date = ((ArrayList<String>)mylist).toArray(new String[mylist.size()]);
			    String[] quote = ((ArrayList<String>)mylist).toArray(new String[mylist.size()]);


			    String temp;
			    for(i=0;i<mylist.size();i++)
			    {
					temp =(String) mylist.get(i);
				    date[i] = temp.substring(0, 9);
			        quote[i] = temp.substring(11);
			        System.out.println(temp);
			    }
			    scanner.close();
			}
			catch (FileNotFoundException e)
			{
			    e.printStackTrace();
            }


			if (args[0].compareTo(s1)== 0)
			{
				simpleStockSpanAlgorithm(date.lenght);
			}
			else if (args[0].compareTo(s2)== 0)
			{
				stackStockSpanAlgorithm(date.lenght);
		    }
			else if (args[0].compareTo(s3)==0)
			{
				countingTime(100);
		    }
			else
			{
				System.out.println("please try again");
			}

		}
		else
		{
			System.out.println("please try again");
		}
    }
    int i,n,k;
    boolean span_end;
    public static void simpleStockSpanAlgorithm(int n)
    {
		int span;
		for (i= 1; i< n; i++)
		{
			k = 1;
			span_end= false;
			while ((i-k>=1) && ((not) span_end))
			{
				if (quote[i-k] <= quote[i])
				{
					k++;
				}
				else
				{
					span_end= true;
				}
			}
			span = k;
			if (args[0].compareTo(s1)== 0)
			{
				System.out.println(date[i] + "," + span );
			}
		}
	}

    public static void stackStockSpanAlgorithm(int n)
	{
		push(0);
		span = 1;
		for (i=1; i < n ;i++)
		{
			while (((not) empty()) && (quote[top()]<= quote[i]))
			{
				pop();
			}
			if (empty())
			{
				span = i + 1;
			}
			else
			{
				span = i - top();
			}
			push(i);
			if (args[0].compareTo(s2)== 0)
			{
				System.out.println(date[i] + "," + span );
			}
		}
	}

	public static void countingTime(int n)
	{
		long startTime = System.currentTimeMillis();
		simpleStockSpanAlgorithm(n);
		long endTime = System.currentTimeMillis();
		System.out.println("Naive implementation took:" + (endTime - startTime) + "millis");
		long startTime = System.currentTimeMillis();
		stackStockSpanAlgorithm(n);
		long endTime = System.currentTimeMillis();
		System.out.println("Stack implementation took:" + (endTime - startTime) + "millis");
	}
}
