import ch.qos.logback.classic.encoder.PatternLayoutEncoder

statusListener(OnConsoleStatusListener)

def appenderList = ["CONSOLE"]

appender("CONSOLE", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    }
}

root(INFO, appenderList)
