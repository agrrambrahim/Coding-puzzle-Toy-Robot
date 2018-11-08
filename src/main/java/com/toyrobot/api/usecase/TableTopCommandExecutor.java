package com.toyrobot.api.usecase;

import com.toyrobot.api.core.command.Command;
import com.toyrobot.api.core.tabletop.TableTop;

import java.util.LinkedList;

public class TableTopCommandExecutor implements CommandExecutor {
    private TableTop tableTop;

    public TableTopCommandExecutor(TableTop tableTop) {
        this.tableTop = tableTop;
    }

    public CommandResult run(LinkedList<Command> commands) {
        CommandResult result = CommandResult.FAILED;
        for (Command command : commands) {
            result = command.executeOn(tableTop);
        }
        return result;
    }
}
