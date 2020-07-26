package com.toyrobot.api.core.tabletop;

import com.toyrobot.api.adapters.presenters.ResultPrinter;

public class Robot {
    public Orientation facingOrientation;
    private Position robotPosition;

    public Robot(Orientation facingOrientation, Position robotPosition) {
        this.facingOrientation = facingOrientation;
        this.robotPosition = robotPosition;
    }

    public boolean moveForward(int defaultTableDimensions) {
        Position potentialPosition = calculateNewPosition(robotPosition);
        if (potentialPosition.isInTheSquareTableTopOf(defaultTableDimensions)) {
            this.robotPosition = potentialPosition;
            return true;
        }

        return false;
    }

    private Position calculateNewPosition(Position robotPosition) {
        Position potentialPosition = new Position(robotPosition);
        switch (facingOrientation) {
            case NORTH:
                return potentialPosition.incrementYCoordinate();
            case EAST:
                return potentialPosition.incrementXCoordinate();
            case WEST:
                return potentialPosition.decrementXCoordinate();
            case SOUTH:
                return potentialPosition.decrementYCoordinate();
        }
        return potentialPosition;
    }

    public String report(ResultPrinter printer) {
        return printer.printReport(robotPosition.report(printer), facingOrientation.report(printer));
    }

    public void changeOrientation(int cardinalDirection) {
        this.facingOrientation = facingOrientation.changeCardinalDirection(cardinalDirection);
    }
}
