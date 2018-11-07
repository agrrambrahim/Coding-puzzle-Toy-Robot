package com.toyrobot.api.tabletop;

import java.util.LinkedList;

public class CommandRunnerService {
    private TableTop tableTop;

    public CommandRunnerService(TableTop tableTop) {
        this.tableTop = tableTop;
    }

    public CommandResult runCommands(LinkedList<Command> commands) {
        CommandResult result = CommandResult.FAILED;
        for (Command command : commands) {
            result = command.executeOn(tableTop);
        }
        return result;
    }
}
