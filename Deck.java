import java.util.*;

public class Deck {
	Card[] cards;
	//Constructors
	public Deck() {
		cards = new Card[52];
		int cdnum = 0;
		for(int suit = 0; suit < 4; suit++) {
			for(int name = 2; name <= 14; name++) {
				Card appendage = new Card(suit, name);
				cards[cdnum] = appendage;
				cdnum++;
			}
		}
	}

	
	//Instance Methods
	public void shuffle() { //Shuffles cards
		ArrayList<Card> temp = new ArrayList<Card>();
		
		for(Card cd: cards) {
			temp.add(cd);
		}
		
		for(int i = 0; i < cards.length; i++) {
			int curInd = (int) Math.floor(Math.random()*(temp.size()));
			cards[i] = temp.get(curInd);
			temp.remove(curInd);
		}
	}

	public Card deal() {
		Card dealt = cards[0];
		Card[] temp = new Card[cards.length-1];
		
		for(int i = 0; i < cards.length-1; i++) {
			temp[i] = cards[i+1];
		}
		
		cards = temp.clone();
		return dealt;
	}

	//toString
	public String toString() {
		String str = "\n";
		int ct = 1;
		for(Card cd: cards) {
			str += "Card #" + ct + ": " + cd + "\n";
			ct++;
		}
		return str;
	}
	
}