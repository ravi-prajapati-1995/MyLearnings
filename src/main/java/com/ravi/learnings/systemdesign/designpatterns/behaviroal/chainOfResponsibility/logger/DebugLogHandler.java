package com.ravi.learnings.systemdesign.designpatterns.behaviroal.chainOfResponsibility.logger;

public class DebugLogHandler extends BaseLogHandler {
    public DebugLogHandler(final LogHandler next) {
        super(next);
    }

    @Override
    public void log(final int level, final String message) {
        if (level == DEBUG) {
            System.out.println(YELLOW + message + RESET);
        } else {
            super.log(level, message);
        }
    }
}
