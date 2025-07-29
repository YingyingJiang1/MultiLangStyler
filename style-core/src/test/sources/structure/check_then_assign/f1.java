// Seq=[-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class E {
	static long calc(List<Node> list,long[] b,int i)
	{
		//bInd
		Node first = list.get(i);
		int bInd = (first.ind - 1);
		if(bInd==-1)
		{
			bInd=2;
		}

		return 0l;
	}

	static class Node { int ind; }
}
