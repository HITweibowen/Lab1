import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ctrl_ShortestPath {
	ShortestPath path = new ShortestPath();
	public Vector<DigraphNode> HeadNodeList;
	public Vector<String> NodeList;
	public Map<String, Boolean> Visit;
    public Vector<PQueue> NodeShortPath;
    public Vector<String> ShortPath;
    public String result;

	public ctrl_ShortestPath()
	{
		HeadNodeList = new Vector<DigraphNode >();
		NodeList = new Vector<String>();
		Visit = new HashMap<String, Boolean>();
		NodeShortPath = new Vector<PQueue>();
		ShortPath = new Vector<String>();
	}

	public ctrl_ShortestPath(Vector<DigraphNode> HeadNodeList, Vector<String> NodeList, Map<String, Boolean> Visit)
	{
		this.HeadNodeList = HeadNodeList;
		this.NodeList = NodeList;
		this.Visit = Visit;
		NodeShortPath = new Vector<PQueue>();
		ShortPath = new Vector<String>();
	}

	public void init() {
		path.setHeadNodeList(HeadNodeList);
		path.setNodeList(NodeList);
		path.setVisit(Visit);
	}

	public void twoWords(String word1, String word2) {
		result = path.TwoPointsGetShortPath(word1, word2);
	}

	public void setShortPath() {
		ShortPath = path.getShortPath();
	}

	public void setNodeShortPath() {
		NodeShortPath = path.getNodeShortPath();
	}

}
