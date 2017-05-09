import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args){
		final int N = 100000;
		StringBuilder compStr;
		AvlTree t = new AvlTree();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i=0;i<N;i++)
			list.add(Integer.valueOf(i));
		Collections.shuffle(list);
		
		for (int i=0;i<N;i++)
			t.add(list.get(i));
		
		compStr = new StringBuilder("[");
		for (int i=0;i<N-1;i++)
			compStr.append(String.valueOf(i) + " ");
		compStr.append(String.valueOf(N-1) + "]");
		
		if (t.toString().equals(compStr.toString()))
			System.out.println("Ok!");
		else
			System.out.println("Error!");
		
		/*String result = t.toString();
		for (int i=0;i<(result.length()+99)/100;i++) //round up
		{
			int endIndex = i*100+100;
			if (endIndex >= result.length())
				endIndex = result.length();
			System.out.println(result.substring(i*100, endIndex));
		}*/
	}

}
