package com.mowitnow.kata.Business;

import com.mowitnow.kata.beans.CoordinateBean;
import com.mowitnow.kata.business.InstructionBusiness;
import com.mowitnow.kata.enumeration.Instruction;
import com.mowitnow.kata.enumeration.Orientation;
import com.mowitnow.kata.factory.BusinessFactory;
import com.mowitnow.kata.models.Position;
import lombok.SneakyThrows;
import org.junit.Test;
import static org.fest.assertions.Assertions.assertThat;

public class InstructionBusinessTest {
    private final InstructionBusiness instructionBusiness = new BusinessFactory().buildInstructionBusinessImpl();

    @Test
    @SneakyThrows
    public void forward() {
        Position limitPosition = new Position(5, 5);
        CoordinateBean bean = new CoordinateBean();
        bean.setOrientation(Orientation.SOUTH);
        bean.setPosition(new Position(2,1));
        Position nextPosition = instructionBusiness.forward(bean, limitPosition);
        assertThat(nextPosition.toString()).isEqualTo("2 0");
    }

    @SneakyThrows
    @Test
    public void turnRightTest () {
        Orientation next = instructionBusiness.right(Orientation.NORTH);
        assertThat(next).isEqualTo(Orientation.EAST);
        next = instructionBusiness.right(Orientation.WEST);
        assertThat(next).isEqualTo(Orientation.NORTH);
        next = instructionBusiness.right(Orientation.SOUTH);
        assertThat(next).isEqualTo(Orientation.WEST);
        next = instructionBusiness.right(Orientation.EAST);
        assertThat(next).isEqualTo(Orientation.SOUTH);
    }

    @SneakyThrows
    @Test
    public void turnLeftTest () {
        Orientation next = instructionBusiness.left(Orientation.NORTH);
        assertThat(next).isEqualTo(Orientation.WEST);
        next = instructionBusiness.left(Orientation.WEST);
        assertThat(next).isEqualTo(Orientation.SOUTH);
        next = instructionBusiness.left(Orientation.SOUTH);
        assertThat(next).isEqualTo(Orientation.EAST);
        next = instructionBusiness.left(Orientation.EAST);
        assertThat(next).isEqualTo(Orientation.NORTH);
    }

    @Test
    @SneakyThrows
    public void executeInstruction() {
        Position limitPosition = new Position(5, 5);
        CoordinateBean bean = new CoordinateBean();
        bean.setOrientation(Orientation.SOUTH);
        bean.setPosition(new Position(2,3));

        instructionBusiness.executeInstruction(bean, Instruction.FORWARD, limitPosition);
        assertThat(bean.getOrientation()).isEqualTo(Orientation.SOUTH);
        assertThat(bean.getPosition()).isEqualTo(new Position(2,2));

        instructionBusiness.executeInstruction(bean, Instruction.RIGHT, limitPosition);
        assertThat(bean.getOrientation()).isEqualTo(Orientation.WEST);
        assertThat(bean.getPosition()).isEqualTo(new Position(2,2));
    }
}
