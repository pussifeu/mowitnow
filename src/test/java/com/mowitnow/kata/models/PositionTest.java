package com.mowitnow.kata.models;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PositionTest {

	@Test
	public void isOutBound(){
		Position coordinate = new Position(5,5);
		Position c0 = new Position(-1,1);
		Position c1 = new Position(1,1);
		assertThat(coordinate.isInsideLawn(c0)).isFalse();
		assertThat(coordinate.isInsideLawn(c1)).isTrue();
	}
}
