package nju.zs.creature.goodcharacter;

import nju.zs.Position;

import javax.swing.*;

public class CalabashBoy extends GoodCharacter implements Comparable<CalabashBoy> {

	private static ImageIcon boy1 = new ImageIcon(CalabashBoy.class.getResource("1.png"));
	public CalabashBoy(Color color, Seniority seniority, Position position , ImageIcon icon){
		super(position, icon);
		this.color = color;	
		this.seniority = seniority;
	}

	@Override
	public void setDefaultImageIcon() {
		this.icon = boy1;
	}

	@Override
	protected void fight() {
	}

	public int compareTo(CalabashBoy o) {
		return this.seniority.compareTo(o.seniority);
	}

	public Color getColor(){
		return color;
	}
	public Seniority getSeniority() {
		return seniority;
	}

	@Override
	public String toString(){
		return "Boy"+(seniority.ordinal()+1);
	}

	private Color color;
	private Seniority seniority;
}

enum Color{
	RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
}

enum Seniority{
	ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN
}
