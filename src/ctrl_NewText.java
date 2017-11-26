import java.util.Map;
import java.util.Vector;

public class ctrl_NewText {
	public NewText text = new NewText();
	public Vector<DigraphNode> HeadNodeList;
	public Vector<String> NodeList;
	public Map<String, Boolean> Visit;
	public String answer;

	public ctrl_NewText(Vector<DigraphNode> HeadNodeList, Vector<String> NodeList, Map<String, Boolean> Visit) {
		this.HeadNodeList = HeadNodeList;
		this.NodeList = NodeList;
		this.Visit = Visit;
	}

	public void init() {
		text.setHeadNodeList(HeadNodeList);
		text.setNodeList(NodeList);
		text.setVisit(Visit);
	}

	public void getNewText(String input) {
		answer = text.GetNewText(input);
	}
}
