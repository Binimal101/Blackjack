import java.util.*;

class Hand {
	boolean dealer = false;
	ArrayList<Card> cards;
	
	public Hand() {
		this.cards = new ArrayList<Card>();
	}

	public Hand(boolean dealer) {
		this.dealer = true;
		this.cards = new ArrayList<Card>();
	}

	public void aceReduction() {
		for(int k = 0; k < 4; k++) { //four aces in a deck
			for(int i = 0; i < cards.size(); i++) {
				if(cards.get(i).name == 14) {
					cards.get(i).changeAce();
					if(!quickBust()) {
						return;
					}
				}
				
			}
		}
	}

	public boolean quickBust() {
		int tot = 0;
		for(Card cd: cards) {
			tot += cd.value;
		}
		return tot > 21;
	}
	
	public boolean isBusted() {
		int tot = 0;
		
		for(Card cd: cards) {
			tot += cd.value;
		}
		
		if(tot > 21) { //If we are over 
			aceReduction(); //Look for an ace and switch it
			if(tot > 21) { //Still over? then bust
				return true;
			} else { //After switched ace, not a bust
				return false;
			}
		} else { //Not busted.
			return false;
		}
	}
	
	public boolean dealMe(Card card) {
		cards.add(card);
		if(isBusted()) {
			return true;
		} 
		return false;
	}

	public int value() {
		int tot = 0;
		for(Card cd: cards) {
			tot += cd.value;
		}
		return tot;
	}

	public String prettyValue() {
		int v = value();
		if(v == 21) {
			return "Blackjack";
		} else {
			return String.valueOf(v);
		}
	}
	
	public String toString() {
		String str = "[";
		for(Card cd: cards) {
			str += cd + ", ";
		}
		return str.substring(0, str.length() - 2) + "]";
	}
}