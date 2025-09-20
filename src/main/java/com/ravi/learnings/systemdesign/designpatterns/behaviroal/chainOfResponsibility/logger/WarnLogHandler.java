package com.ravi.learnings.systemdesign.designpatterns.behaviroal.chainOfResponsibility.logger;

public class WarnLogHandler extends BaseLogHandler {
    public WarnLogHandler(final LogHandler next) {
        super(next);
    }

    @Override
    public void log(final int level, final String message) {
        if (level == WARN) {
            System.out.println(CYAN  + message + RESET);
        } else {
            super.log(level, message);
        }
    }
}
