package com.ravi.learnings.systemdesign.designpatterns.behaviroal.chainOfResponsibility.logger;

abstract public class BaseLogHandler implements LogHandler {
    private LogHandler next;

    public BaseLogHandler(final LogHandler next) {
        this.next = next;
    }

    @Override
    public void setNext(final LogHandler handler) {
        handler.setNext(next);
    }

    @Override
    public void log(final int level, final String message) {
        if (next != null) {
            next.log(level, message);
        }
    }
}
