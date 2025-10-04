package com.ravi.learnings.systemdesign.designpatterns.behaviroal.chainOfResponsibility;

import com.ravi.learnings.systemdesign.designpatterns.behaviroal.chainOfResponsibility.logger.*;

public class Application {
    public static void main(String[] args) {
        final var errorLogHandler = new ErrorLogHandler(null);
        final var warnLogHandler = new WarnLogHandler(errorLogHandler);
        final var infoLogHandler = new InfoLogHandler(warnLogHandler);
        final var debugLogHandler = new DebugLogHandler(infoLogHandler);

        debugLogHandler.log(LogHandler.DEBUG, "THis is debug");
        debugLogHandler.log(LogHandler.WARN, "THis is warning");
        debugLogHandler.log(LogHandler.ERROR, "THis is error");
        debugLogHandler.log(LogHandler.INFO, "THis is info");
    }
}
