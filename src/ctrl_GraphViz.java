import java.io.File;
import java.util.Vector;

public class ctrl_GraphViz {

	public Vector<DigraphNode> HeadNodeList;
    public Vector<String> KeyNode;
    public Vector<String> ShortPath;

	public ctrl_GraphViz()
	{
		HeadNodeList = new Vector<DigraphNode >();
		KeyNode = new Vector<String>();
		ShortPath = new Vector<String>();
	}

	public ctrl_GraphViz(Vector<DigraphNode> HeadNodeList, Vector<String> KeyNode, Vector<String> ShortPath)
	{
		this.HeadNodeList = HeadNodeList;
		this.KeyNode = KeyNode;
		this.ShortPath = ShortPath;
	}

	public void picture()
	{
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());

		for(DigraphNode node : HeadNodeList)
		{
			while(node != null )
			{
				System.out.print(node.Words+" ");
				node=node.Next;
			}
			System.out.println();
		}

		for(DigraphNode node : HeadNodeList)
		{
			DigraphNode head = node;
			node=node.Next;
			while(node != null )
			{
				gv.addln(head.Words + " -> " + node.Words + "[label="+ node.Weight + "];");
				node=node.Next;
			}
		}

		gv.addln(gv.end_graph());
		//System.out.println(gv.getDotSource());

		String type = "png";
	//	String type = "dot";
	//	String type = "fig";    // open with xfig
	//	String type = "pdf";
	//	String type = "ps";
	//	String type = "svg";    // open with inkscape
	//	String type = "png";
	//	String type = "plain";
		//File out = new File("/out." + type);   // Linux
		File out = new File("D:\\out." + type);    // Windows
		gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
	}

	public void picture_qjc()
	{
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());

		for(DigraphNode node : HeadNodeList)
		{
			DigraphNode head = node;
			node=node.Next;
			while(node != null && KeyNode.size()>=1)
			{
				if(head.Words.equals(KeyNode.get(0)) && !node.Words.equals(KeyNode.get(1)) && KeyNode.contains(node.Words))
				{
					gv.addln(head.Words + " -> " + node.Words + "[color=red, label="+ node.Weight + "];" + head.Words+"[color=red];"+ node.Words+"[color=blue];");
				}
				else if(KeyNode.contains(head.Words) && node.Words.equals(KeyNode.get(1)))
				{
					gv.addln(head.Words + " -> " + node.Words + "[color=red, label="+ node.Weight + "];" + head.Words+"[color=blue];"+ node.Words+"[color=red];");
				}
				else
				{
					gv.addln(head.Words + " -> " + node.Words + "[label="+ node.Weight + "];");
				}
				node=node.Next;
			}
		}

		gv.addln(gv.end_graph());
		//System.out.println(gv.getDotSource());
		/*for(String a : KeyNode)
		{
			System.out.print(a+" ");
		}*/

		String type = "png";
		File out = new File("D:\\qjcout." + type);    // Windows
		gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
	}

	public boolean In(String word1, String word2)
	{
		for(int i=0; i<ShortPath.size(); i++)
		{
			if(KeyNode.contains(word1) && KeyNode.contains(word2) && KeyNode.indexOf(word1, i*KeyNode.size()/ShortPath.size())+1==KeyNode.indexOf(word2, i*KeyNode.size()/ShortPath.size()))
			{
				return true;
			}
		}
		return false;
	}

	public void picture_zdlj()
	{
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		KeyNode.clear();

		for(int i=0; i<ShortPath.size(); i++)
		{
			String[] tmp = ShortPath.get(i).split(" ");
			for(int j=0; j<tmp.length; j++)
				KeyNode.add(tmp[j]);
		}

		for(DigraphNode node : HeadNodeList)
		{
			DigraphNode head = node;
			node=node.Next;
			while(node != null && KeyNode.size()>=1)
			{
				if(In(head.Words, node.Words))
				{
					gv.addln(head.Words + " -> " + node.Words + "[color=red, label="+ node.Weight + "];" + head.Words+"[color=red];"+ node.Words+"[color=red];");
				}

				else
				{
					gv.addln(head.Words + " -> " + node.Words + "[label="+ node.Weight + "];");
				}
				node=node.Next;
			}
		}

		gv.addln(gv.end_graph());
		//System.out.println(gv.getDotSource());
		/*for(String a : KeyNode)
		{
			System.out.print(a+" ");
		}*/

		String type = "png";
		File out = new File("D:\\zdljout." + type);    // Windows
		gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
	}

	public boolean In_sjyz(String word1, String word2)
	{
		for(int i=0; i<KeyNode.size()-1; i++)
		{
			if(KeyNode.get(i).equals(word1) && KeyNode.get(i+1).equals(word2))
				return true;
		}
		return false;
	}
	public void picture_sjyz()
	{
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());

		for(DigraphNode node : HeadNodeList)
		{
			DigraphNode head = node;
			node=node.Next;
			while(node != null && KeyNode.size()>=1)
			{
				if(KeyNode.contains(head.Words))
				{
					gv.addln(head.Words+"[color=red]");
				}
				if(KeyNode.contains(node.Words))
				{
					gv.addln(node.Words+"[color=red]");
				}
				if(KeyNode.contains(head.Words) && KeyNode.contains(node.Words) && In_sjyz(head.Words, node.Words))
				{
					gv.addln(head.Words + " -> " + node.Words + "[color=red, label="+ node.Weight + "];" + head.Words+"[color=red];"+ node.Words+"[color=red];");
				}
				else
				{
					gv.addln(head.Words + " -> " + node.Words + "[label="+ node.Weight + "];");
				}
				node=node.Next;
			}
		}

		gv.addln(gv.end_graph());
		//System.out.println(gv.getDotSource());
		/**for(String a : KeyNode)
		{
			System.out.print(a+" ");
		}*/

		String type = "png";
		File out = new File("D:\\sjyzout." + type);    // Windows
		gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
	}

}
