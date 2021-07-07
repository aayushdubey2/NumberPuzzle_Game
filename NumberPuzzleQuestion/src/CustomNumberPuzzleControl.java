import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		System.out.println(emptyCellId);
		System.out.println(buttonClicked);
		int k=0;
		for(Button b: buttons)
		{
			k++;
			if(b==buttonClicked)
				break;
		}
		
		if(Math.abs((k-1)-emptyCellId)==1 || Math.abs((k-1)-emptyCellId)==4)
		{
			swapButton(buttons[emptyCellId],buttonClicked);
		}		
		k=0;
		for(Button b: buttons)
		{
			k++;
			if(b.getLabel()=="  ")	
				break;
		}
		emptyCellId=k-1;
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		int count=0,flag=0,j=0;
		
		while(count!=15)
		{
			int a = getRandomNumber();
			a=(int)Math.ceil(a*0.15);
			if(a==0)
				a++;
			
			flag=0;
			for(int i=0;i<count;i++)
			{
				if(a==arr[i])
				{
					flag=1;
				}
			}
			if(flag==0)
			{
				arr[j++]=a;
				count++;
			}		
		}
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int max=0,flag=0;
		for(int i:getIntegerArrayOfButtonIds(buttons))
		{
			if(i>max)
				max=i;
			else
			{ 
				flag=1; break;
			}
		}
		if(flag==1)
			winner=false;
		return winner;
	}
}