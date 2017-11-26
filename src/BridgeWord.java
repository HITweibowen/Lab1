import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class BridgeWord {
	private Vector<String> BridgeWords;
	private Vector<DigraphNode> HeadNodeList;
	private Vector<String> NodeList;
	private Map<String, Boolean> Visit;
	private Vector<String> KeyNode;

	public BridgeWord() {
		BridgeWords = new Vector<String>();
		HeadNodeList = new Vector<DigraphNode >();
		NodeList = new Vector<String>();
		Visit = new HashMap<String, Boolean>();
		KeyNode = new Vector<String>();
	}

	public Vector<String> getBridgeWords() {
		return BridgeWords;
	}
	public void setBridgeWords(Vector<String> BridgeWords) {
		this.BridgeWords = BridgeWords;
	}
	public Vector<DigraphNode> getHeadNodeList() {
		return HeadNodeList;
	}
	public void setHeadNodeList(Vector<DigraphNode> HeadNodeList) {
		this.HeadNodeList = HeadNodeList;
	}
	public Vector<String> getNodeList() {
		return NodeList;
	}
	public void setNodeList(Vector<String> NodeList) {
		this.NodeList = NodeList;
	}
	public Vector<String> getKeyNode() {
		return KeyNode;
	}
	public void setKeyNode(Vector<String> KeyNode) {
		this.KeyNode = KeyNode;
	}
	public Map<String, Boolean> getVisit() {
		return Visit;
	}
	public void setVisit(Map<String, Boolean> Visit) {
		this.Visit = Visit;
	}

	public String GetBridgeWords(String StartString, String EndString)
	{
		String Str;
		BridgeWords.clear();
		KeyNode.clear();
		KeyNode.add(StartString);
		KeyNode.add(EndString);
		for (int i = 0; i < HeadNodeList.size(); i++)
		{
			if (StartString.equals(HeadNodeList.get(i).Words))
			{
				if (NodeList.contains(EndString))
				{
					GBridgeWords(StartString, EndString, i);
					Str = "No bridge words from " + "\"" + StartString + "\"" +" to \"" + EndString + "\" !";
					    return Str;
				}
				Str =  "No "  + "\"" + EndString + "\" in the graph!";
				return Str;
			}
		}
		if (NodeList.contains(EndString))
			Str = "No "  + "\"" + StartString + "\" in the graph!";
		else
			Str = "No "  + "\"" + StartString + "\"  and \"" + EndString + "\" in the graph!";
		return Str;
	}

	public void GBridgeWords(String StartString, String EndString, int i)
	{
		for (int j = 0; j < NodeList.size(); j++)
			Visit.put(NodeList.get(j), false);
		int Distance = 1;
		DFS(HeadNodeList.get(i), Distance, EndString);
	}

	public void DFS(DigraphNode Node, int Distance, String EndString)
	{
		Visit.put(Node.Words, true);
    	DigraphNode NextNode = Node.Next;
        while (NextNode != null)
        {
        	if (!Visit.get(NextNode.Words))
        	{
        		if (Distance <= 2)
        		{
	        		if (Distance == 2)
	        		{
	        			if (EndString.equals(NextNode.Words) )
	        			{
	        		        BridgeWords.addElement(Node.Words);
	        		        KeyNode.addElement(Node.Words);
	        			}
	        		}
	        		else
	        		{
		        		for (int i = 0; i < HeadNodeList.size(); i++)
		        			if ((NextNode.Words).equals(HeadNodeList.get(i).Words))
		        			{
		        				DFS(HeadNodeList.get(i), Distance + 1, EndString);
		        			    break;
		        			}
	        		}
        		}
        	}
        	NextNode = NextNode.Next;
        }
	}

}
