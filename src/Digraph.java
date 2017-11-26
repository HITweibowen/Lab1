
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;

public class Digraph
{
	public Vector<DigraphNode> HeadNodeList;
	public Vector<String> NodeList;
	public Vector<String> FileText;
	public Map<String, Boolean> Visit;
    private String FileLastString;
    public Vector<String>BridgeWords;
    public Vector<PQueue> NodeShortPath;
    public Vector<String> KeyNode;
    public Vector<String> ShortPath;

	public Digraph()
	{
		HeadNodeList = new Vector<DigraphNode >();
		NodeList = new Vector<String>();
		FileText = new Vector<String>();
		BridgeWords = new Vector<String>();
		Visit = new HashMap<String, Boolean>();
		NodeShortPath = new Vector<PQueue>();
		KeyNode = new Vector<String>();
		ShortPath = new Vector<String>();
	}

	public void Insert(String CurNodeKey, String PosNodeKey)
	{
		DigraphNode NewNode = new DigraphNode();
		NewNode.Words = PosNodeKey;
		int i = 0;
		int Size = HeadNodeList.size();
		for (; i < Size; i++)
		{
			if (CurNodeKey.equals (HeadNodeList.get(i).Words))//遍历表头节点,单词连续重复的情况
			{
				DigraphNode Node = HeadNodeList.get(i);

				while (Node != null)
				{
					if (Node.Words.equals(PosNodeKey))
					{
						Node.Weight++;
					    break;
					}
					Node = Node.Next;
				}
				if (Node == null)
				{
					NewNode.Next = (HeadNodeList.get(i)).Next;
					NewNode.Weight = 1;
					(HeadNodeList.get(i)).Next = NewNode;
					(HeadNodeList.get(i)).AdjPointNumber++;
				}
				break;
			}
		}
		if (i == Size)//出现新的表头节点
		{
			DigraphNode HeadNode = new DigraphNode();
			HeadNode.Next = HeadNode.Next = NewNode;//改
			HeadNode.Words = CurNodeKey;
			HeadNode.AdjPointNumber ++;
			NewNode.Next = null;
			NewNode.Weight = 1;
		    HeadNodeList.addElement(HeadNode);
		}
	}

	public void ReadFileBuildDigraph(String FileName)
	{
		File file = new File(FileName);
		try(
		Reader reader = new InputStreamReader(new FileInputStream(file)))
		{
			int tempchar;
			int CurFlag = 1;
			StringBuffer CurNodeKey = new StringBuffer("");
			StringBuffer PosNodeKey = new StringBuffer("");
			while((tempchar = reader.read()) != -1)
			{
				if (tempchar != '\r')
				{
					int x = ChangeWords(CurFlag, CurNodeKey, PosNodeKey, tempchar);

					CurFlag = x;
				}
		    }


			if (!PosNodeKey.toString().equals(""))
			{
				Insert(CurNodeKey.toString(), PosNodeKey.toString());
				FileText.addElement(CurNodeKey.toString());//
				FileText.addElement(PosNodeKey.toString());//
				if (!NodeList.contains(CurNodeKey.toString()))
			    {
					NodeList.addElement(CurNodeKey.toString());//
			    }
				if (!NodeList.contains(PosNodeKey.toString()))
			    {
					NodeList.addElement(PosNodeKey.toString());//
			    }
			}
			else
			{
				FileText.addElement(FileLastString);//
				if (!NodeList.contains(FileLastString))
			    {
			    	Visit.put(FileLastString, false);
			        NodeList.addElement(FileLastString);
			    }//
			}
	}
	catch(IOException e){
	    e.printStackTrace();}

}

	public int ChangeWords(int CurFlag, StringBuffer CurNodeKey, StringBuffer PosNodeKey, int tempchar)
	{
		if ( ((char)tempchar >= 'a' && (char)tempchar <= 'z')
	     ||  ((char)tempchar >= 'A' && (char)tempchar <= 'Z'))
		{
			if ((char)tempchar >= 'A' && (char)tempchar <= 'Z')
                tempchar += 32;//大小写转换
			if (CurFlag == 1)
				CurNodeKey.append((char)tempchar);
			else
				PosNodeKey.append((char)tempchar);
		}
		else
		{
			if (CurFlag == 0 && !(PosNodeKey.toString()).equals(""))
			{
				if(!( CurNodeKey.toString()).equals(""))
				{Insert(CurNodeKey.toString(), PosNodeKey.toString());
				FileText.addElement(CurNodeKey.toString());//

				if (!NodeList.contains(CurNodeKey.toString()))
			    {
			    	Visit.put(CurNodeKey.toString(), false);
			        NodeList.addElement(CurNodeKey.toString());
			    }//
				}
				CurNodeKey.replace(0, CurNodeKey.length(), PosNodeKey.toString());
			    CurNodeKey = new StringBuffer(PosNodeKey.toString());
			    FileLastString = PosNodeKey.toString();
			    PosNodeKey.delete(0, PosNodeKey.length());
			    PosNodeKey = new StringBuffer("");
			}
			else
				CurFlag = 0;
		}
		return CurFlag;
	}
}

