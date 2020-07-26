package com.toyrobot.api.core.tabletop;

import com.toyrobot.api.adapters.presenters.ResultPrinter;

public enum Orientation {
    NORTH, EAST, SOUTH, WEST;

    public String report(ResultPrinter printer) {
        return printer.printOrientation(this.name());
    }

    public Orientation changeCardinalDirection(int cardinalDirection) {
        int existingDirectionsCount = values().length;
        int nextOrientationOrdinal = this.ordinal() + cardinalDirection;

        if (nextOrientationOrdinal < 0)
            nextOrientationOrdinal = existingDirectionsCount - nextOrientationOrdinal;

        if (nextOrientationOrdinal >= existingDirectionsCount)
            nextOrientationOrdinal -= existingDirectionsCount;

        return Orientation.values()[nextOrientationOrdinal];
    }
}
