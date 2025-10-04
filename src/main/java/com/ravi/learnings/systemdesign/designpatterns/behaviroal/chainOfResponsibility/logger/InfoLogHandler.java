package com.ravi.learnings.systemdesign.designpatterns.behaviroal.chainOfResponsibility.logger;

public class InfoLogHandler extends BaseLogHandler {
    public InfoLogHandler(final LogHandler next) {
        super(next);
    }

    @Override
    public void log(final int level, final String message) {
        if (level == INFO) {
            System.out.println(WHITE + message + RESET);
        } else {
            super.log(level, message);
        }
    }
}
