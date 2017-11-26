import java.util.Vector;
import org.junit.Before;
import org.junit.Test;

public class GetBridgeWordsTest {
	Digraph D = new Digraph();
	ctrl_BridgeWord cbridge;
	String File = "C:/Users/weibowen/Desktop/Lab.txt";
	String Str = "";
	String S = "";

	@Before
	public void setup() throws Exception {
		D.ReadFileBuildDigraph(File);
		cbridge = new ctrl_BridgeWord(D.HeadNodeList, D.NodeList, D.Visit);
		cbridge.init();
	}

	@Test
	public void test1()
	{
		cbridge.getBridgeWords("the", "of");//得到桥接词
		cbridge.setBridgeWords();
		Str = cbridge.answer;//得到答案
		D.BridgeWords = cbridge.BridgeWords;

        Vector<String> BridgeWords = D.BridgeWords;
        if (BridgeWords.size() >= 1)
		{
            if (BridgeWords.size() == 1) {
            	S +=  "the bridge words from \"the\" to \"of\" is :";
            }
            else {
            	S += "the bridge words from \"the\" to \"of\" are :";
            }
        	for (int I = 0; I < BridgeWords.size(); I++) {
        		S += (BridgeWords.get(I) + "  ");
        	}
        	System.out.println(S);
		}
        else {
        	System.out.println(Str);
        }
        System.out.print("\n");
	}

	@Test
	public void test2() {
		cbridge.getBridgeWords("big", "time");//得到桥接词
		cbridge.setBridgeWords();
		Str = cbridge.answer;//得到答案
		D.BridgeWords = cbridge.BridgeWords;

        Vector<String> BridgeWords = D.BridgeWords;
        if (BridgeWords.size() >= 1)
		{
            if (BridgeWords.size() == 1)
            	S +=  "the bridge words from \"big\" to \"time\" is :";
            else
            	S += "the bridge words from \"big\" to \"time\" are :";
        	for (int I = 0; I < BridgeWords.size(); I++)
        		S += (BridgeWords.get(I) + "  ");
        	System.out.println(S);
		}
        else
        	System.out.println(Str);
        System.out.print("\n");
	}

	@Test
	public void test3() {
		cbridge.getBridgeWords("time", "big");//得到桥接词
		cbridge.setBridgeWords();
		Str = cbridge.answer;//得到答案
		D.BridgeWords = cbridge.BridgeWords;

        Vector<String> BridgeWords = D.BridgeWords;
        if (BridgeWords.size() >= 1)
		{
            if (BridgeWords.size() == 1)
            	S +=  "the bridge words from \"time\" to \"big\" is :";
            else
            	S += "the bridge words from \"time\" to \"big\" are :";
        	for (int I = 0; I < BridgeWords.size(); I++)
        		S += (BridgeWords.get(I) + "  ");
        	System.out.println(S);
		}
        else
        	System.out.println(Str);
        System.out.print("\n");
	}

	@Test
	public void test4() {
		cbridge.getBridgeWords("time", "time");//得到桥接词
		cbridge.setBridgeWords();
		Str = cbridge.answer;//得到答案
		D.BridgeWords = cbridge.BridgeWords;

        Vector<String> BridgeWords = D.BridgeWords;
        if (BridgeWords.size() >= 1)
		{
            if (BridgeWords.size() == 1)
            	S +=  "the bridge words from \"time\" to \"time\" is :";
            else
            	S += "the bridge words from \"time\" to \"time\" are :";
        	for (int I = 0; I < BridgeWords.size(); I++)
        		S += (BridgeWords.get(I) + "  ");
        	System.out.println(S);
		}
        else
        	System.out.println(Str);
        System.out.print("\n");
	}

	@Test
	public void test5() {
		cbridge.getBridgeWords("in", "time1");//得到桥接词
		cbridge.setBridgeWords();
		Str = cbridge.answer;//得到答案
		D.BridgeWords = cbridge.BridgeWords;

        Vector<String> BridgeWords = D.BridgeWords;
        if (BridgeWords.size() >= 1)
		{
            if (BridgeWords.size() == 1)
            	S +=  "the bridge words from \"in\" to \"time1\" is :";
            else
            	S += "the bridge words from \"in\" to \"time1\" are :";
        	for (int I = 0; I < BridgeWords.size(); I++)
        		S += (BridgeWords.get(I) + "  ");
        	System.out.println(S);
		}
        else
        	System.out.println(Str);
        System.out.print("\n");
	}

	@Test
	public void test6() {
		cbridge.getBridgeWords("in1", "time");//得到桥接词
		cbridge.setBridgeWords();
		Str = cbridge.answer;//得到答案
		D.BridgeWords = cbridge.BridgeWords;

        Vector<String> BridgeWords = D.BridgeWords;
        if (BridgeWords.size() >= 1)
		{
            if (BridgeWords.size() == 1)
            	S +=  "the bridge words from \"in1\" to \"time\" is :";
            else
            	S += "the bridge words from \"in1\" to \"time\" are :";
        	for (int I = 0; I < BridgeWords.size(); I++)
        		S += (BridgeWords.get(I) + "  ");
        	System.out.println(S);
		}
        else
        	System.out.println(Str);
        System.out.print("\n");
	}

	@Test
	public void test7() {
		cbridge.getBridgeWords("abc", "time1");//得到桥接词
		cbridge.setBridgeWords();
		Str = cbridge.answer;//得到答案
		D.BridgeWords = cbridge.BridgeWords;

        Vector<String> BridgeWords = D.BridgeWords;
        if (BridgeWords.size() >= 1)
		{
            if (BridgeWords.size() == 1)
            	S +=  "the bridge words from \"abc\" to \"time1\" is :";
            else
            	S += "the bridge words from \"abc\" to \"time\" are :";
        	for (int I = 0; I < BridgeWords.size(); I++)
        		S += (BridgeWords.get(I) + "  ");
        	System.out.println(S);
		}
        else
        	System.out.println(Str);
        System.out.print("\n");
	}
}
