package com.toyrobot.api.tabletop;

import com.toyrobot.api.ResultPrinter;

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
