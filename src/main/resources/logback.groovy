appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern="[%date{HH:mm:ss}] %-28.-28logger{0}  %.-1level   %message%n"
    }
}

logger("com.sevenlist", DEBUG)

root(INFO, ["STDOUT"])