package com.ravi.learnings.systemdesign.designpatterns.behaviroal.chainOfResponsibility.logger;

public class ErrorLogHandler extends BaseLogHandler {
    public ErrorLogHandler(final LogHandler next) {
        super(next);
    }

    @Override
    public void log(final int level, final String message) {
        if (level == ERROR) {
            System.out.println(RED + message + RESET);
        } else {
            super.log(level, message);
        }
    }
}
