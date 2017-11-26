import java.util.Vector;
import org.junit.Test;
import org.junit.Before;

public class GetShortPathTest {
	Digraph D = new Digraph();
	ctrl_ShortestPath cpath;
	String File = "C:/Users/weibowen/Desktop/Lab1.txt";
	String Result;

	@Before
	public void setup() throws Exception {
		D.ReadFileBuildDigraph(File);
		cpath = new ctrl_ShortestPath(D.HeadNodeList, D.NodeList, D.Visit);
	    cpath.init();
	}

	@Test
	public void test1() {
	     cpath.twoWords("the", "of");
	     cpath.setNodeShortPath();
	     Result = cpath.result;
	     D.NodeShortPath = cpath.NodeShortPath;

        if (D.NodeShortPath.size() == 0)
        	System.out.println(Result);
        else {
	        for (int i = 0;i < D.NodeShortPath.size(); i++) {
		    	if (D.NodeShortPath.get(i).End.equals("of")) {
		    		if (D.NodeShortPath.get(i).Costs == 0) {
		    			System.out.println(Result);
		                break;
		            }
		    		System.out.println("\"the\" to \"of\" " + " 权值为：" + D.NodeShortPath.get(i).Costs + " 路径如下：");
		    		Vector <PQueue> S = D.NodeShortPath;
	    		    for (int k = 0; k < S.get(i).P.size(); k++)
	    	            System.out.println(S.get(i).P.get(k));
	    		    break;
		    	}
		    }
        }
        System.out.print("\n");
	}

	@Test
	public void test2() {
	    cpath.twoWords("i", "the");
	    cpath.setNodeShortPath();
	    Result = cpath.result;
	    D.NodeShortPath = cpath.NodeShortPath;

        for (int i = 0;i < D.NodeShortPath.size(); i++) {
	    	if (D.NodeShortPath.get(i).End.equals("the")) {
	    		if (D.NodeShortPath.get(i).Costs == 0) {
	    			System.out.println(Result);
	                break;
	            }
	    		System.out.println("\"i\" to \"the\" " + " 权值为：" + D.NodeShortPath.get(i).Costs);
	    		Vector <PQueue> S = D.NodeShortPath;
    		    for (int k = 0; k < S.get(i).P.size(); k++)
    	            System.out.println(S.get(i).P.get(k));
	    		break;
	    	}
	    }
        System.out.print("\n");
	}

	@Test
	public void test3() {
	    cpath.twoWords("abcd1", "abc");
	    cpath.setNodeShortPath();
	    Result = cpath.result;
	    D.NodeShortPath = cpath.NodeShortPath;

        if (D.NodeShortPath.size() ==0)
        	System.out.println(Result);
        else {
	        for (int i = 0;i < D.NodeShortPath.size(); i++) {
		    	if (D.NodeShortPath.get(i).End.equals("abc")) {
		    		if (D.NodeShortPath.get(i).Costs == 0) {
		    			System.out.println(Result);
		                break;
		            }
		    		System.out.println("\"abcd1\" to \"abc\" " + " 权值为：" + D.NodeShortPath.get(i).Costs + " 路径如下：");
		    		Vector <PQueue> S = D.NodeShortPath;
	    		    for (int k = 0; k < S.get(i).P.size(); k++)
	    	            System.out.println(S.get(i).P.get(k));
		    		break;
		    	}
		    }
        }
        System.out.print("\n");
   }

	@Test
	public void test4() {
	    cpath.twoWords("i", "abc");
	    cpath.setNodeShortPath();
	    Result = cpath.result;
	    D.NodeShortPath = cpath.NodeShortPath;

        if (D.NodeShortPath.size() ==0)
        	System.out.println(Result);
        else
        {
	        for (int i = 0;i < D.NodeShortPath.size(); i++)
		    {
		    	if (D.NodeShortPath.get(i).End.equals("abc"))
		    	{
		    		if (D.NodeShortPath.get(i).Costs == 0)
		            {
		    			System.out.println(Result);
		                break;
		            }
		    		System.out.println("\"i\" to \"abc\" " + " 权值为：" + D.NodeShortPath.get(i).Costs + " 路径如下：");
		    		Vector <PQueue> S = D.NodeShortPath;
	    		    for (int k = 0; k < S.get(i).P.size(); k++)
	    	            System.out.println(S.get(i).P.get(k));
		    		break;
		    	}
		    }
        }
        System.out.print("\n");
    }

	@Test
	public void test5() {
	    cpath.twoWords("abc", "i");
	    cpath.setNodeShortPath();
	    Result = cpath.result;
	    D.NodeShortPath = cpath.NodeShortPath;

        if (D.NodeShortPath.size() ==0)
        	System.out.println(Result);
        else
        {
	        for (int i = 0;i < D.NodeShortPath.size(); i++)
		    {
		    	if (D.NodeShortPath.get(i).End.equals("i"))
		    	{
		    		if (D.NodeShortPath.get(i).Costs == 0)
		            {
		    			System.out.println(Result);
		                break;
		            }
		    		System.out.println("\"abc\" to \"i\" " + " 权值为：" + D.NodeShortPath.get(i).Costs + " 路径如下：");
		    		Vector <PQueue> S = D.NodeShortPath;
	    		    for (int k = 0; k < S.get(i).P.size(); k++)
	    	            System.out.println(S.get(i).P.get(k));
		    		break;
		    	}
		    }
        }
        System.out.print("\n");
    }

	@Test
	public void test6() {
	    cpath.twoWords("i", "lucky");
	    cpath.setNodeShortPath();
	    Result = cpath.result;
	    D.NodeShortPath = cpath.NodeShortPath;

        if (D.NodeShortPath.size() ==0)
        	System.out.println(Result);
        else
        {
	        for (int i = 0;i < D.NodeShortPath.size(); i++) {
		    	if (D.NodeShortPath.get(i).End.equals("lucky")) {
		    		if (D.NodeShortPath.get(i).Costs == 0) {
		    			System.out.println(Result);
		                break;
		            }
		    		System.out.println("\"i\" to \"lucky\" " + " 权值为：" + D.NodeShortPath.get(i).Costs + " 路径如下：");
		    		Vector <PQueue> S = D.NodeShortPath;
	    		    for (int k = 0; k < S.get(i).P.size(); k++)
	    	            System.out.println(S.get(i).P.get(k));
		    		break;
		    	}
		    }
	    }
        System.out.print("\n");
	}

	@Test
	public void test7() {
	    cpath.twoWords("in", "in");
	    cpath.setNodeShortPath();
	    Result = cpath.result;
	    D.NodeShortPath = cpath.NodeShortPath;

	    if (D.NodeShortPath.size() > 0) {
	    	int Flag = 0;
		    for (int i = 0; i < D.NodeShortPath.size(); i++) {
		    	if (D.NodeShortPath.get(i).Costs > 0) {
		        	System.out.println("\"in\" to \"" + D.NodeShortPath.get(i).End + "\" 权值为：" +
		        			D.NodeShortPath.get(i).Costs + " 路径如下：");
		        	Vector <PQueue> S = D.NodeShortPath;
	    		    for (int k = 0; k < S.get(i).P.size(); k++)
	    	            System.out.println(S.get(i).P.get(k));
	    		    System.out.print("\n");
	        	    Flag++;
	        	}
	        }
		    if (Flag == 0)
		    	System.out.println("\"the\" 和图中所有点都不可达\n");
        }
	    else
	    	System.out.println("\"the\" 不在图中\n");
	}

	@Test
	public void test8() {
	    cpath.twoWords("study", "study");
	    cpath.setNodeShortPath();
	    Result = cpath.result;
	    D.NodeShortPath = cpath.NodeShortPath;

	    if (D.NodeShortPath.size() > 0) {
	    	int Flag = 0;
		    for (int i = 0; i < D.NodeShortPath.size(); i++) {
		    	if (D.NodeShortPath.get(i).Costs > 0)
	        	{
		        	System.out.println("Study1 to " + D.NodeShortPath.get(i).End + " 权值为：" + D.NodeShortPath.get(i).Costs);
	    		    for (int k = 0; k < D.NodeShortPath.get(i).P.size(); k++)
	    	            System.out.println(D.NodeShortPath.get(i).P.get(k));
		            System.out.print("\n");
		            Flag++;
	        	}
	        }
		    if (Flag == 0)
		    	System.out.println("\"Study\" 和图中所有点都不可达\n");
        }
	    else
	    	System.out.println("\"Study\" 不在图中\n");
     }

	@Test
	public void test9() {
	    cpath.twoWords("lucky", "lucky");
	    cpath.setNodeShortPath();
	    Result = cpath.result;
	    D.NodeShortPath = cpath.NodeShortPath;
;

	    if (D.NodeShortPath.size() > 0)
        {
	    	int Flag = 0;
		    for (int i = 0; i < D.NodeShortPath.size(); i++)
	        {
		    	if (D.NodeShortPath.get(i).Costs > 0)
	        	{
		    		System.out.println("lucky to " + D.NodeShortPath.get(i).End + " 权值为：" + D.NodeShortPath.get(i).Costs);
		    		Vector <PQueue> S = D.NodeShortPath;
	    		    for (int k = 0; k < S.get(i).P.size(); k++)
	    	            System.out.println(S.get(i).P.get(k));
		            System.out.print("\n");
		            Flag++;
	        	}

	        }
		    if (Flag == 0)
		    	System.out.println("\"lucky\" 和图中所有点都不可达\n");
        }
	    else
	    	System.out.println("\"lucky\" 不在图中\n");
	}

}
