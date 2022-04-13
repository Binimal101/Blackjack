import java.util.*;

public class Card {
	/*
		0: Hearts
		1: Diamonds
		2: Clubs
		3: Spades
	*/
	public int suit;

	/*
	11: Jack == 10
	12: Queen == 10
	13: King == 10
	14: Ace == 1 OR == 11
	*/
	public int name;

	public int value; // 1, 10 or 11 if face cards else name
	
	
	public Card(int suit, int name) {
		this.suit = suit;
		this.name = name;

		//Value Checks
		if(name == 14) {
			this.value = 11; //each time we check the current score, we check to see if they went over, if they have an ace score-=10
		} else if(name > 10) {
			this.value = 10;
		} else {
			this.value = name;
		}
	}

	public void changeAce() {
		if(name == 14 && value == 11) {
			value = 1; //Dunno if it affects out of scope
		}
	}
	
	public String stringifySuit() {
		switch(suit) {
			case 0:
				return "Hearts";
			case 1:
				return "Diamonds";
			case 2:
				return "Clubs";
			case 3:
				return "Spades";
			default:
				return "Blank";
		}
	}

	private String stringifyName() {
		Map<Integer, String> names  = new HashMap<Integer, String>() {{
    		put(1, "Ace");
    		put(2, "2");
			put(3, "3");
			put(4, "4");
			put(5, "5");
			put(6, "6");
			put(7, "7");
			put(8, "8");
			put(9, "9");
			put(10, "10");
			put(11, "Jack");
			put(12, "Queen");
			put(13, "King");
			put(14, "Ace");
		}};
		
		return names.get(name);
	}
	
	public String toString() {
		return stringifyName() + " of " + stringifySuit();
	}
}