package lab1;

/*this is branch B1 second change*/
public class DigraphNode
{
	String Words;
	DigraphNode Next;
	int Weight;
	int AdjPointNumber;//��ʾ���ٸ������ͷ�ڵ�����
	boolean flag = false;

	public DigraphNode()
	{
		Next = null;
		AdjPointNumber = 0;
	}
}