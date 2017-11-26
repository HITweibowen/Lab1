
public class NewText extends BridgeWord {

	public String GetNewText(String Text)
	{
		String Result = "";
		String[] Words = Text.split(" ");
		Result += Words[0];
		for (int i = 0; i < Words.length - 1; i++)
		{
			getBridgeWords().clear();
			GetBridgeWords(Words[i], Words[i + 1]);
			if (getBridgeWords().size() != 0)
			{
			    Result += (" " + getBridgeWords().get((int)(Math.random() * getBridgeWords().size())));
			}
			Result += (" " + Words[i + 1]);
		}
		return Result;
	}

}
