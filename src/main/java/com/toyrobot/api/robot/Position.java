package com.toyrobot.api.robot;

import com.toyrobot.api.ResultPrinter;

public class Position {
    private int xCoordinate;
    private int yCoordinate;

    public Position(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Position(Position robotPosition) {
        this.xCoordinate = robotPosition.xCoordinate;
        this.yCoordinate = robotPosition.yCoordinate;
    }

    public boolean isInTheSquareTableTopOf(int squareDimension) {
        return ((0 <= xCoordinate) && (xCoordinate <= squareDimension - 1) && (0 <= yCoordinate) && (yCoordinate <= squareDimension - 1));
    }

    public Position incrementYCoordinate() {
        this.yCoordinate += 1;
        return this;
    }

    public Position incrementXCoordinate() {
        this.xCoordinate += 1;
        return this;
    }

    public Position decrementXCoordinate() {
        this.xCoordinate -= 1;
        return this;
    }

    public Position decrementYCoordinate() {
        this.yCoordinate -= 1;
        return this;
    }

    public String report(ResultPrinter printer) {
        return printer.printPosition(xCoordinate, yCoordinate);
    }
}
