package com.github.q9029.aikatsustars.dto.domain;

public class RareType {

	public static final RareType PR = new RareType(0, "PR");
	public static final RareType SPR = new RareType(1, "SPR");
	public static final RareType R = new RareType(2, "R");
	public static final RareType N = new RareType(3, "N");
	public static final RareType CP = new RareType(4, "CP");
	public static final RareType P = new RareType(5, "P");
	public static final RareType MC = new RareType(6, "MC");

	private int value;
	private String name;

	private RareType(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}
	public String getName() {
		return name;
	}
}
