import java.util.Vector;

public class ctrl_RandomWalk {
	RandomWalk random = new RandomWalk();
	public Vector<DigraphNode> HeadNodeList;
	public Vector<String> NodeList;
    public Vector<String> KeyNode;
    public String word;

	public ctrl_RandomWalk()
	{
		HeadNodeList = new Vector<DigraphNode >();
		NodeList = new Vector<String>();
		KeyNode = new Vector<String>();
	}

	public ctrl_RandomWalk(Vector<DigraphNode> HeadNodeList, Vector<String> NodeList, Vector<String> KeyNode)
	{
		this.HeadNodeList = HeadNodeList;
		this.NodeList = NodeList;
		this.KeyNode = KeyNode;
	}

	public void init() {
		random.setHeadNodeList(HeadNodeList);
		random.setNodeList(NodeList);
		random.setKeyNode(KeyNode);
	}

	public void getRandomWord(String pre) {
		word = random.GetRandomWords(pre);
	}

	public void setKeyNode() {
		this.KeyNode = random.getKeyNode();
	}

}
