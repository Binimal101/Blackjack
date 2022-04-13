import java.util.*;

class Blackjack {
	public Blackjack() {
		
	}

	public void startGame() {
		clearConsole(1);
		Deck d1 = new Deck();
		d1.shuffle();

		Hand playerHand = new Hand();
		playerHand.dealMe(d1.deal());
		
		Hand dealerHand = new Hand();
		dealerHand.dealMe(d1.deal());

		System.out.println("Your hand: " + playerHand);
		System.out.println("Dealer's: " + dealerHand);

		boolean isPlayerBusted;
		String choice = "";
		while(playerHand.value() <= 21) {
			
			while(true) {
				clearConsole(1);
				choice = input("Your hand: " + playerHand + "\nHand Value: " + playerHand.prettyValue() + "\n\nDealer's hand: " + dealerHand + "\nHand Value: " + dealerHand.prettyValue() + "\n\nInput 1 to hit\nInput 0 to stand\n>>> ");
				if(choice.equals("0") || choice.equals("1")) {
					break;
				}
			}
			
			if(choice.equals("0")) {
				break;	
				
			} else if(choice.equals("1")) {
				isPlayerBusted = playerHand.dealMe(d1.deal());
				
				if(isPlayerBusted) {
					playerHand.aceReduction();
					if(playerHand.quickBust()) {
						break;
					}
				}
			}
			
		}

		boolean isDealerBusted;
		while(dealerHand.value() < 17) {
			isDealerBusted = dealerHand.dealMe(d1.deal());
		}
		
		clearConsole(1);

		System.out.println("Your Hand: " + playerHand + "\nHand Value: " + (playerHand.quickBust() ? "Busted with " + playerHand.prettyValue() : String.valueOf(playerHand.prettyValue())));
		System.out.println("\nDealers Hand: " + dealerHand + "\nHand Value: " + (dealerHand.quickBust() ? "Busted with " + dealerHand.prettyValue() : String.valueOf(dealerHand.prettyValue())) + "\n");

		isPlayerBusted = playerHand.quickBust(); //Was defined, but out of scope to be accessed here, redefinition
		isDealerBusted = dealerHand.quickBust(); //Same as above
		
		if(isPlayerBusted) {
			if(isDealerBusted) {
				System.out.println("The dealer has busted, but you busted first, sorry!\nDealer Wins");
			} else {
				System.out.println("You have busted but the dealer has " + dealerHand.prettyValue() + "\n\nDEALER WINS");
			}
			
		} else if(isDealerBusted) {
			System.out.println("The dealer has busted and you have " + playerHand.prettyValue() + "\n\nYOU WIN");
			
		} else {
			if(dealerHand.value() > playerHand.value()) {
				System.out.println("The dealer has " + dealerHand.prettyValue() + " and you have " + playerHand.prettyValue() + "\n\nDEALER WINS");
			} else if(playerHand.value() > dealerHand.value()) {
				System.out.println("The dealer has " + dealerHand.prettyValue() + " and you have " + playerHand.prettyValue() + "\n\nYOU WIN");
			} else {
				System.out.println("The dealer has " + dealerHand.prettyValue() + " and you have " + playerHand.prettyValue() + "\n\nTIE GAME");
			}
		}
	}
	
	public static String input(String output) {
		Scanner sc = new Scanner(System.in);
		System.out.print(output);
		String in = sc.nextLine();
		
		return in;
	}
	
	public static String input() {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		
		return in;
	}
	
	//Where 0 clears the console
	//Where 1 clears console and prints title
	public static void clearConsole(int intent) {
		switch(intent) {
			case 0:
				System.out.print("\033[H\033[2J");
				System.out.flush();
				
				return;
			case 1:
				System.out.print("\033[H\033[2J");
				System.out.flush();
				
				printTitle();
				return;
		}
	}

	public static void startGameLoop() {
		String response = "1";
		
		while(response.equals("1")) {
			
			Blackjack game = new Blackjack();
			game.startGame();
			// String toPrint = game.getGameText
		
			try {
				Thread.sleep(3*1000);
			} catch(InterruptedException e) {
				//Do nothing
			}
		
			response = "";
			printLineBreak();
			while(!response.equals("0") && !response.equals("1")) {
				game.clearConsole(1);
				
				response = game.input("New Game?\nYes: 1\nNo: 0\n>>> ");
			}
		}
	}

	public static void printTitle() {
		String[] text = new String[] {
			"oooooooooo o888                       oooo       ooooo                      oooo        ",
			(" 888    888 888   ooooooo    ooooooo   888  ooooo 888   ooooooo    ooooooo   888  ooooo "),
			(" 888oooo88  888   ooooo888 888     888 888o888    888   ooooo888 888     888 888o888    "),
			(" 888    888 888 888    888 888         8888 88o   888 888    888 888         8888 88o   "),
			("o888ooo888 o888o 88ooo88 8o  88ooo888 o888o o888o 888  88ooo88 8o  88ooo888 o888o o888o "),
			("                                               8o888                                    "),
		};
		for(String ln : text) {
			System.out.println(ln);
		}
		printLineBreak();
		System.out.println("\n");
	}

	public static void printLineBreak() {
		System.out.println("***************************************************************************************");
	}
	
	public static void startScreen() {
		clearConsole(0);
		String[] text = new String[] {
			"oooooooooo o888                       oooo       ooooo                      oooo        ",
			(" 888    888 888   ooooooo    ooooooo   888  ooooo 888   ooooooo    ooooooo   888  ooooo "),
			(" 888oooo88  888   ooooo888 888     888 888o888    888   ooooo888 888     888 888o888    "),
			(" 888    888 888 888    888 888         8888 88o   888 888    888 888         8888 88o   "),
			("o888ooo888 o888o 88ooo88 8o  88ooo888 o888o o888o 888  88ooo88 8o  88ooo888 o888o o888o "),
			("                                               8o888                                    "),
		};
		
		for(String ln : text) {
			for(int i = 0; i < ln.length(); i++) {
				System.out.print(ln.charAt(i));
				try {
					Thread.sleep(20);
				} catch(InterruptedException e) {
					//Do nothing
				}
			}
			
			System.out.println();
			
		}
		printLineBreak();
		System.out.println("\n");
		
		try {
			Thread.sleep(1000*5);
		} catch(InterruptedException e) {
			//Do nothing
		}
		startGameLoop();
	}
}