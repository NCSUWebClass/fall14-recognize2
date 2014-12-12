package com.istudy.enums;

/**
 * @author Gregory Daniels
 *
 */
public enum Difficulty {
	EASY("Easy"), MED("Medium"), HAR("Hard");
	
	private String name;

	private Difficulty(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}

	public static Difficulty parse(String difficulty) {
		for (Difficulty type : Difficulty.values()) {
			if (type.getName().equals(difficulty)) {
				return type;
			}
		}
		return null;
	}
}
