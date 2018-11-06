package com.toyrobot.api;

import com.toyrobot.api.robot.Position;

import static java.lang.Integer.parseInt;

public class PositionFactory {
    public static Position fromPlacingCommandString(String input){
        String[] placingCommandArguments = input.split(",");
        return new Position(parseInt(placingCommandArguments[1]),parseInt(placingCommandArguments[2]));
    }
}
