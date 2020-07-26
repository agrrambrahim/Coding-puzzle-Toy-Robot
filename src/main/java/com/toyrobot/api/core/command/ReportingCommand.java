package com.toyrobot.api.core.command;

import com.toyrobot.api.adapters.presenters.ResultPrinter;
import com.toyrobot.api.usecase.CommandResult;
import com.toyrobot.api.core.tabletop.TableTop;

public class ReportingCommand extends Command {

    private ResultPrinter printer;

    public ReportingCommand(ResultPrinter printer) {
        this.printer = printer;
    }

    @Override
    public CommandResult executeOn(TableTop tableTop) {
        String output = tableTop.report(printer);
        CommandResult result = CommandResult.SUCCESSWITHOUTPUT;
        result.SetOutput(output);
        return result;
    }
}
