import java.util.Vector;

public class RandomWalk {

	private Vector<DigraphNode> HeadNodeList;
	private Vector<String> NodeList;
	private Vector<String> KeyNode;

	public RandomWalk()
	{
		HeadNodeList = new Vector<DigraphNode >();
		NodeList = new Vector<String>();
		KeyNode = new Vector<String>();
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

	public String GetRandomWords(String pre)
	{
		if(pre=="")//≥ı ºªØ
		{
			KeyNode.clear();
			for(DigraphNode n : HeadNodeList)
			{
				while(n!=null)
				{
					n.flag=false;
					n=n.Next;
				}
			}
			String word = NodeList.get( (int)(NodeList.size() * Math.random() ));
			KeyNode.add(word);
			return word;
		}

		int i;
		for(i=0; i<HeadNodeList.size(); i++)
		{
			if(HeadNodeList.get(i).Words.equals(pre))
				break;
		}
		if(i==HeadNodeList.size())
			return "-end-";

		else
		{
			DigraphNode node = HeadNodeList.get(i);
			int child=(int)(Math.random() * node.AdjPointNumber);
			for(i=0; i<=child ; i++)
			{
				node = node.Next;
			}
			if(node.flag==true)
			{
				KeyNode.add(node.Words);
				return "-end-"+node.Words;
			}
			else
			{
				node.flag=true;
				KeyNode.add(node.Words);
				return node.Words;
			}
		}
	}

}
