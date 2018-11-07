package com.toyrobot.api.robot;

import static com.toyrobot.api.robot.Orientation.*;

public class OrientationFactory {
    public static Orientation from(String input) {
        switch (input.toUpperCase()) {
            case "EAST":
                return EAST;
            case "WEST":
                return WEST;
            case "NORTH":
                return NORTH;
            case "SOUTH":
                return SOUTH;
            default:
                throw new IllegalArgumentException("UNSUPPORTED ORIENTATION " + input);
        }
    }

    public static Orientation fromPlacingCommandString(String input) {
        String[] placingCommandArguments = input.split(",");
        return from(placingCommandArguments[2]);
    }
}
