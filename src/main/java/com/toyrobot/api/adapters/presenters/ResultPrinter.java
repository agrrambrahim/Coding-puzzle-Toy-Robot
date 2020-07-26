package com.toyrobot.api.adapters.presenters;

public interface ResultPrinter {
    public String printReport(String positionReport, String orientationReport);

    public String printPosition(int xCoordinate, int yCoordinate);

    public String printOrientation(String orientation);

    public String printMissingRobot();
}
