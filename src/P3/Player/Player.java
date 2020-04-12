package P3.Player;

import P3.Piece.*;
import java.util.*;

public class Player {
	// AF:该玩家m名字对应playerName，是否是当前玩家对应firstHand
	// RI playerName!=null
	// secure way:using defensive copy and all fields are private
	private final String playerName;
	private boolean firstHead;

	
	//checkRep()
	public void checkRep() {
		assert playerName!=null;
	}
	public Player(String name) {
		
		this.playerName = name;
		checkRep();
	}

	public String getName() {
		String a = this.playerName;
		checkRep();
		return a;
	}

	public void setFirstHead() {
		checkRep();
		this.firstHead = true;
	}

	public void setSceondHead() {
		checkRep();
		this.firstHead = false;
	}

	public boolean getFirstHead() {
		boolean a = firstHead;
		checkRep();
		return a;
	}

}
