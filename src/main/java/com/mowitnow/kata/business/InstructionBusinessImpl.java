package com.mowitnow.kata.business;

import com.mowitnow.kata.enumeration.Instruction;
import com.mowitnow.kata.enumeration.Orientation;
import com.mowitnow.kata.beans.CoordinateBean;
import com.mowitnow.kata.exceptions.MowerException;
import com.mowitnow.kata.exceptions.MowerMessage;
import com.mowitnow.kata.models.Position;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InstructionBusinessImpl implements InstructionBusiness {
    /**
     * Move mower
     *
     * @param bean          : initial position
     * @param limitPosition : lawn coordinate, limit position
     * @return Position : new position
     * @throws MowerException
     */
    @Override
    public Position forward(CoordinateBean bean, Position limitPosition) throws MowerException {
        Position nextCoordinate;
        int x;
        int y;
        switch (bean.getOrientation()) {
            case NORTH:
                x = bean.getPosition().getX();
                y = bean.getPosition().getY() + 1;
                break;
            case EAST:
                x = bean.getPosition().getX() + 1;
                y = bean.getPosition().getY();
                break;
            case SOUTH:
                x = bean.getPosition().getX();
                y = bean.getPosition().getY() - 1;
                break;
            case WEST:
                x = bean.getPosition().getX() - 1;
                y = bean.getPosition().getY();
                break;
            default:
                throw new MowerException(MowerMessage.INCORRECT_POSITION.getMessage());
        }
        nextCoordinate = new Position(x, y);
        if (limitPosition.isInsideLawn(nextCoordinate)) {
            return nextCoordinate;
        }
        return bean.getPosition();
    }

    /**
     * turn mower to right
     *
     * @param orientation : mower initial orientation
     * @return new orientation
     * @throws MowerException
     */
    public Orientation right(Orientation orientation) throws MowerException {
        Orientation nextOrientation;
        switch (orientation) {
            case NORTH:
                nextOrientation = Orientation.EAST;
                break;
            case EAST:
                nextOrientation = Orientation.SOUTH;
                break;
            case SOUTH:
                nextOrientation = Orientation.WEST;
                break;
            case WEST:
                nextOrientation = Orientation.NORTH;
                break;
            default:
                throw new MowerException(MowerMessage.INCORRECT_ORIENTATION.getMessage());
        }
        return nextOrientation;
    }

    /**
     * turn mower to left
     *
     * @param orientation : mower initial orientation
     * @return new orientation
     * @throws MowerException
     */
    public Orientation left(Orientation orientation) throws MowerException {
        Orientation nextOrientation;
        switch (orientation) {
            case NORTH:
                nextOrientation = Orientation.WEST;
                break;
            case EAST:
                nextOrientation = Orientation.NORTH;
                break;
            case SOUTH:
                nextOrientation = Orientation.EAST;
                break;
            case WEST:
                nextOrientation = Orientation.SOUTH;
                break;
            default:
                throw new MowerException(MowerMessage.INCORRECT_ORIENTATION.getMessage());
        }
        return nextOrientation;
    }

    /**
     * execute one instruction ( A, D ou G)
     *
     * @param bean: coordinate of mower position and orientation
     * @param instruction: instruction ( A, D ou G)
     * @param limitPosition: limit of lawn
     * @throws MowerException
     */
    @Override
    public void executeInstruction(CoordinateBean bean, Instruction instruction, Position limitPosition) throws MowerException {
        switch (instruction) {
            case FORWARD:
                bean.setPosition(forward(bean, limitPosition));
                break;
            case RIGHT:
                bean.setOrientation(right(bean.getOrientation()));
                break;
            case LEFT:
                bean.setOrientation(left(bean.getOrientation()));
                break;
            default:
                throw new MowerException(MowerMessage.INCORRECT_INSTRUCTION.getMessage());
        }
    }
}