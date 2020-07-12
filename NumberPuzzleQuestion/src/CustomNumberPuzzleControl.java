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
//		System.out.println("s:"+buttonClicked.getLabel());
		String label = buttonClicked.getLabel();
		//Your logic here
		int count = 0;
		for (Button b : buttons) {
			if (b == buttonClicked) {
				break;
			}
			count++;
		}
		swapButton(buttons[game.getEmptyCellId()], buttonClicked);
		
		game.setEmptyCellId(count);
		
		return count;

	}
	
	public int ConvertS2I (String s) {
		System.out.println("s:"+s);
		switch (s) {
		case "1":
			return 1;
		case "2":
			return 2;
		case "3":
			return 3;
		case "4":
			return 4;
		case "5":
			return 5;
		case "6":
			return 6;
		case "7":
			return 7;
		case "8":
			return 8;
		case "9":
			return 9;
		case "10":
			return 10;
		case "11":
			return 11;
		case "12":
			return 12;
		case "13":
			return 13;
		case "14":
			return 14;
		case "15":
			return 15;
		default:
			return 0;
		}
	}
	
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
//		int a = getRandomNumber();
		int count = 0;
		
		while (count!=15) {
			int a = (int)getRandomNumber();
			if (a>15) {
				a = 15;
			}else if (a<1){
				a = 1;
			}
			
			boolean found = false;
			for (int i = 0; i<=count; i++) {
				if (arr[i] == a) {
					found = true;
					break;
				}
			}
			if (found == false) {
				arr[count] = a;
				count++;
			}
		}

		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] arr = getIntegerArrayOfButtonIds(buttons);
		for (int i=0; i<15; i++) {
			if (arr[i] != i+1) {
				winner = false;
				break;
			}
		}
		return winner;
	}
}