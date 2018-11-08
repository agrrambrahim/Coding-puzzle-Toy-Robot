package com.toyrobot.api.usecase;

import com.toyrobot.api.core.command.Command;
import org.springframework.context.annotation.Bean;

import java.util.LinkedList;
public interface CommandExecutor {
    public CommandResult run(LinkedList<Command> commands);
}
