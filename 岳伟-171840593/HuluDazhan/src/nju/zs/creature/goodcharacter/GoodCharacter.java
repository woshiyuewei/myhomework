package nju.zs.creature.goodcharacter;

import nju.zs.Position;
import nju.zs.creature.Creature;
import nju.zs.creature.badcharacter.BadCharacter;

import javax.swing.*;
import java.util.ArrayList;

public abstract class GoodCharacter extends Creature {

	private static ImageIcon boy1 = new ImageIcon(CalabashBoy.class.getResource("1.png"));
	private static ImageIcon boy2 = new ImageIcon(CalabashBoy.class.getResource("2.png"));
	private static ImageIcon boy3 = new ImageIcon(CalabashBoy.class.getResource("3.png"));
	private static ImageIcon boy4 = new ImageIcon(CalabashBoy.class.getResource("4.png"));
	private static ImageIcon boy5 = new ImageIcon(CalabashBoy.class.getResource("5.png"));
	private static ImageIcon boy6 = new ImageIcon(CalabashBoy.class.getResource("6.png"));
	private static ImageIcon boy7 = new ImageIcon(CalabashBoy.class.getResource("7.png"));
	public static CalabashBoy[] getBrothers(){
		CalabashBoy[] boys = new CalabashBoy[7];
	    boys[0] = new CalabashBoy(Color.values()[0], Seniority.values()[0], new Position(0,0),boy1);
	    boys[1] = new CalabashBoy(Color.values()[1], Seniority.values()[1], new Position(0,0),boy2);
	    boys[2] = new CalabashBoy(Color.values()[2], Seniority.values()[2], new Position(0,0),boy3);
	    boys[3] = new CalabashBoy(Color.values()[3], Seniority.values()[3], new Position(0,0),boy4);
	    boys[4] = new CalabashBoy(Color.values()[4], Seniority.values()[4], new Position(0,0),boy5);
	    boys[5] = new CalabashBoy(Color.values()[5], Seniority.values()[5], new Position(0,0),boy6);
	    boys[6] = new CalabashBoy(Color.values()[6], Seniority.values()[6], new Position(0,0),boy7);
		return boys;
	}

	public GoodCharacter(Position position, ImageIcon icon){
		super(position, icon);
	}

	@Override
	public void setStatus(Status status) {
		this.status = status;
		if(this.status!=Status.DEAD)
			this.setDefaultImageIcon();
		else
			this.setImageIcon(goodDeadIcon);
	}

	protected void move(){
		ArrayList<Creature> creatures = room.getCreatures();
		Creature tgt = null;
		int dist = Integer.MAX_VALUE;
		for(Creature ct:creatures)
			if(ct!=this && (ct instanceof BadCharacter) && ct.getStatus()==Status.RUNNING && this.distanceTo(ct.getPosition())<dist){
				tgt = ct;
				dist = this.distanceTo(tgt.getPosition());
			}

		if(tgt!=null)
			this.moveTowards(tgt.getPosition());
	}

	private static ImageIcon goodDeadIcon = new ImageIcon(GoodCharacter.class.getResource("goodDead.png"));
	@Override
	protected void dead() {
		this.setImageIcon(goodDeadIcon);
	}
}
