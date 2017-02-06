import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Hashtable;
public class address {
	public static void main(String[] arg) throws IOException{
		Scanner in=new Scanner(System.in);
		Integer input=0;
		Integer page_number=0;
		boolean exit=false; 
		int index=0;
		char go;
		Hashtable<Integer, Integer>[] h=new Hashtable[100];
		Hashtable<Integer, Integer>[] index_of_pagenumber=new Hashtable[100];
		do
		{
			System.out.print("ÇëÊäÈëĞéÄâµØÖ·£º");
			input=in.nextInt();
			page_number=input/4096;
			exit=false;
			for(int i=0;i<index;i++)
			{
				if(index_of_pagenumber[i].containsKey(page_number))
				{
					h[i].put(input, page_number);
					exit=true;
					break;
				}
			}
			if(!exit)
			{
				h[index]=new Hashtable<Integer, Integer>();
				index_of_pagenumber[index]=new Hashtable<Integer, Integer>();
				index_of_pagenumber[index].put(page_number, 0);
				h[index].put(input, page_number);
				index++;
			}
			System.out.print("ÄãÏë¼ÌĞøÊäÈëÂğ£¿£¨y|n£©£º");
			go=(char)System.in.read();
		}while(go=='y');
		for(int i=0;i<index;i++)
		{
	        for(Iterator<Integer> itor=h[i].keySet().iterator(); itor.hasNext();)  
	        {  
	            Integer word=(Integer)itor.next();  
	            Integer a=(Integer)h[i].get(word); 
	            System.out.println("The Address   "+word+"  contains");  
	            System.out.println("page_number: "+a);  
	            System.out.println("offset£º"+word%2048);  
	        }
		}
		in.close();
	}
	
}