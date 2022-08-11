package com.mowitnow.kata.beans;

import com.mowitnow.kata.enumeration.Orientation;
import com.mowitnow.kata.models.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CoordinateBean {
    private Position position;
    private Orientation orientation;

    @Override
    public String toString() {
        return position.getX()+ " "+ position.getY()+ " " + orientation.getOrientationCode();
    }
}