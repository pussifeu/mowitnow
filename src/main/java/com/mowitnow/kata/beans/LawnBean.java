package com.mowitnow.kata.beans;

import com.mowitnow.kata.models.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LawnBean {
	private Position limitPosition;
}