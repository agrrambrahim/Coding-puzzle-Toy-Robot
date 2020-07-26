package com.toyrobot.api.adapters.presenters;

public class StringResultPrinter implements ResultPrinter {

    private final static String ROBOT_NOT_PLACED_MESSAGE = "Robot is Missing";
    private final static String OUTPUT_PREFIX = "OutPut: ";

    @Override
    public String printReport(String positionReport, String orientationReport) {
        return OUTPUT_PREFIX + positionReport + "," + orientationReport;
    }

    @Override
    public String printPosition(int xCoordinate, int yCoordinate) {
        return String.valueOf(xCoordinate) + "," + String.valueOf(yCoordinate);
    }

    @Override
    public String printOrientation(String orientationName) {
        return orientationName;
    }

    @Override
    public String printMissingRobot() {
        return OUTPUT_PREFIX + ROBOT_NOT_PLACED_MESSAGE;
    }

}
