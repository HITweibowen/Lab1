import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ctrl_BridgeWord {
	public BridgeWord bridge = new BridgeWord();;
	public Vector<String> BridgeWords;
	public Vector<DigraphNode> HeadNodeList;
	public Vector<String> NodeList;
	public Map<String, Boolean> Visit;
	public Vector<String> KeyNode;
	public String answer;

	public ctrl_BridgeWord() {
		BridgeWords = new Vector<String>();
		HeadNodeList = new Vector<DigraphNode >();
		NodeList = new Vector<String>();
		Visit = new HashMap<String, Boolean>();
		KeyNode = new Vector<String>();
	}

	public ctrl_BridgeWord(Vector<DigraphNode> HeadNodeList, Vector<String> NodeList, Map<String, Boolean> Visit) {
		this.HeadNodeList = HeadNodeList;
		this.NodeList = NodeList;
		this.Visit = Visit;
	}

	public void init() {
		bridge.setHeadNodeList(HeadNodeList);//求桥接词需要对3个数组初始化，结果存放在BridgeWords里面
		bridge.setNodeList(NodeList);
		bridge.setVisit(Visit);
	}

	public void getBridgeWords(String word1, String word2) {
		answer = bridge.GetBridgeWords(word1, word2);
	}

	public void setKeyNode() {
		this.KeyNode = bridge.getKeyNode();
	}

	public void setBridgeWords() {
		this.BridgeWords = bridge.getBridgeWords();
	}
}
