import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Vector;

public class ShortestPath {

	private Vector<DigraphNode> HeadNodeList;
	private Vector<String> NodeList;
	private Map<String, Boolean> Visit;
	private Vector<PQueue> NodeShortPath;
	private Vector<String> ShortPath;

	public ShortestPath()
	{
		HeadNodeList = new Vector<DigraphNode >();
		NodeList = new Vector<String>();
		Visit = new HashMap<String, Boolean>();
		NodeShortPath = new Vector<PQueue>();
		ShortPath = new Vector<String>();
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
	public Map<String, Boolean> getVisit() {
		return Visit;
	}
	public void setVisit(Map<String, Boolean> Visit) {
		this.Visit = Visit;
	}
	public Vector<PQueue> getNodeShortPath() {
		return NodeShortPath;
	}
	public Vector<String> getShortPath() {
		return ShortPath;
	}

	public String TwoPointsGetShortPath(String Start, String End)
	{
		NodeShortPath.clear();

		int T1 = 0;
		int T2 = 0;
		for (int i = 0; i < NodeList.size(); i++)
		{
			if (NodeList.get(i).equals(Start) )
				T1++;
			if (NodeList.get(i).equals(End))
				T2++;
			if (T1 == 1 && T2 == 1)
				break;
		}
		if (T1 == 0 && T2 == 0)
			return  "\"" + Start + "\"" + " ��  " + "\"" + End + "\"" +" ����ͼ��\n";
		if (T1 == 0)
			return  "\"" + Start + "\"" + " ����ͼ��\n";
		if (T2 == 0)
			return  "\"" + End + "\"" + " ����ͼ��\n";

		Comparator<PQueue> Order = new Comparator<PQueue>()
		{
			public int compare(PQueue S1, PQueue S2)
			{
				return (S1.Costs - S2.Costs);
			}
		};
		PriorityQueue<PQueue> D = new  PriorityQueue<PQueue>(Order);
		OnePointGetShortPath(D, NodeShortPath, Start);
		for (int i = 0;i < NodeShortPath.size(); i++)
	    {
	    	if (NodeShortPath.get(i).End.equals(End))
	    	{
	    		ShortPath = NodeShortPath.get(i).P;
	    		break;
	    	}
	    }

		if (ShortPath.size() == 0)
		{
			String S = "\"" + Start + "\" �� " + "\"" + End + "\" ���ɴ�\n";
			return S;
		}

        return "hava";
}

	public void DInit(PriorityQueue<PQueue> D, Vector<PQueue> NodeShortPath, String Start)
	{
		for (Iterator<String> it = NodeList.iterator(); it.hasNext();)//�����㼯��
	    {
			String Str = it.next();
			PQueue Node = new PQueue();
			PQueue S = new PQueue();//��¼���·��
	        S.Path = new Vector<String>();
			if (!Str.equals(Start))//���������ʼ��
			{
				Node.Costs = 1000000;//��ʼD����
				Node.End = Str;

		        D.add(Node);

		        S.Path.addElement(Start);
		        S.End = Str;
		        NodeShortPath.addElement(S);//�����㵽���е�����·��
			}
	    }
	}

	public void UpdataStart(PriorityQueue<PQueue> D, Vector<PQueue> NodeShortPath, String Start)
	{
		for (int i = 0; i < HeadNodeList.size(); i++)
		{
			if (HeadNodeList.get(i).Words.equals(Start))
			{
				DigraphNode Node  = HeadNodeList.get(i).Next;
				while (Node != null)
				{
					PQueue SNode = new PQueue();
					for (PQueue SP: D)
				        if (SP.End.equals(Node.Words))//�ҵ�ͼ���ڽӵ���D�ж�Ӧ�Ķ���
	    			    {
		    				SNode = SP;
		    				SNode.Costs = Node.Weight;
		    				D.remove(SP);
		    				D.add(SNode);

		    				for (int k = 0; k < NodeShortPath.size(); k++)//����·��
		                    {
		                    	if (NodeShortPath.get(k).End.equals(SNode.End))
		                        {
		                    		NodeShortPath.get(k).Costs = SNode.Costs;
		                    		NodeShortPath.get(k).Path.addElement(SNode.End);
		                    		NodeShortPath.get(k).P.addElement((Start + " " + SNode.End));//
		                    		break;
		                        }
		                    }

		    				break;
	    			    }
					Node = Node.Next;
				}
			}

		}

	}

	public void OnePointGetShortPath(PriorityQueue<PQueue> D, Vector<PQueue> NodeShortPath, String Start)
	{
		NodeShortPath.clear();

		DInit(D, NodeShortPath, Start);

        UpdataStart(D, NodeShortPath, Start);
	    while(D.peek() != null)//������
	    {
	    	PQueue Node = D.poll();//���ȶ��е�һ����
	    	String TempNodeString = Node.End;
	    	int Costs = Node.Costs;
	        int i = 0;
	    	for (; i < HeadNodeList.size(); i++)//�ҵ�����ͼ�ж�Ӧ����
	        	if (HeadNodeList.get(i).Words.equals(TempNodeString))
	        		break;
	        if (i != HeadNodeList.size())
	        {
	    	    DigraphNode node = HeadNodeList.get(i).Next;//��ӵ�
	    	    while (node != null)
		    	{
		    		 for (PQueue SP: D)
    	                 if (SP.End.equals(node.Words))//�ҵ�ͼ���ڽӵ���D�ж�Ӧ�Ķ���
    		             {
                            if (Costs +  node.Weight <= SP.Costs)//�õ�ǰ�м������������
                            {
                            	int A = 0;
			    				for (; A < NodeShortPath.size(); A++)
	                        	{
	                        	    if (NodeShortPath.get(A).End.equals(Node.End))
	                        	    	break;
	                        	}

		                        for (int B = 0; B < NodeShortPath.size(); B++)
	                        	{
		                        	if (NodeShortPath.get(B).End.equals(node.Words))
	                        	    {
			                        	if (Costs +  node.Weight == SP.Costs)
	                        	    	{
	                        	    		String S = "";
	                        	    		int I = 0;
	                        	    		for (; I < NodeShortPath.get(A).P.size(); I++)
		                        	    	{
	                        	    			S = "";
	                        	    			S = (NodeShortPath.get(A).P.get(I) + " ");
	                        	    			S += node.Words;
	                        	    			NodeShortPath.get(B).P.add(S);
		                        	    	}

	                        	    	}
	                        	    	else
	                        	    	{
	                        	    		String S = "";
		                        	    	for (int I = 0; I < NodeShortPath.get(A).P.size(); I++)
		                        	    	{
		                        	    		S =  NodeShortPath.get(A).P.get(I);
		                        	    		S += (" " + node.Words);
		                        	    		NodeShortPath.get(B).P.addElement(S);
		                        	    		S = "";
		                        	    	}
	                        	    	}
	                        	    }

	                        	    if (NodeShortPath.get(B).End.equals(node.Words))
	                        	    {
	                        	    	if (Costs +  node.Weight < SP.Costs)
	                        	    	{
	                        	    	    NodeShortPath.get(B).Costs = Costs + node.Weight;//����D;
	                        	    	    PQueue SPNode = SP;
	    			            	        SPNode.Costs = Costs + node.Weight;//����D;
	    			            	        D.remove(SP);
	    				    				D.add(SPNode);
	                        	    	    NodeShortPath.get(B).Path.clear();

	                        	    	}

	                        	    	for (int I = 0; I < NodeShortPath.get(A).Path.size(); I++)
	                        	    		NodeShortPath.get(B).Path.addElement(NodeShortPath.get(A).Path.get(I));
	                        	    	NodeShortPath.get(B).Path.addElement(node.Words);

	                        	    }
	                        	}
                            }
                            break;
    		            }
    		        node = node.Next;
		    	  }
	        }
	    }
	}

	public void Traverse()
	{
		for (int i = 0; i < NodeList.size(); i++)
			Visit.put(NodeList.get(i), false);
		for (int i = 0; i < NodeList.size(); i++)
			if (!Visit.get(NodeList.get(i)))
			{
				for (int j = 0; j < HeadNodeList.size(); j++)
				    if (HeadNodeList.get(j).Words.equals(NodeList.get(i)))
				    {
				    	DFSTraverse(HeadNodeList.get(j));
				        break;
				    }
			}
	}

	public void DFSTraverse(DigraphNode Node)
	{
		Visit.put(Node.Words, true);

		DigraphNode NextNode = Node.Next;

		while (NextNode != null)
		{
			if (!Visit.get(NextNode.Words))
			{
				int i = 0;
				for (; i < HeadNodeList.size(); i++)
				    if (HeadNodeList.get(i).Words.equals(NextNode.Words))
				        break;

				if (i != HeadNodeList.size())
		            DFSTraverse(HeadNodeList.get(i));
			}
			NextNode = NextNode.Next;
		}
	}

}
