package com.mowitnow.kata.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Position {
	private int x;
	private int y;

	@Override
	public String toString() {
		return x +" "+ y;
	}

	/**
	 * check if the coordinates of the mower after movement are outside the lawn
	 * @param position
	 * @return true if the coordinates of the mower are inside the lawn
	 */
	public boolean isInsideLawn(Position position){
		return position.getX() >= 0
				&& position.getX() <= this.x
				&& position.getY() >= 0
				&& position.getY() <= this.y;
	}
}