package utils;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.io.StringWriter;
import java.io.PrintWriter;

public class MyFormatter extends Formatter  {
    public String format(LogRecord record) {
        StringBuffer buf = new StringBuffer(180);
        buf.append(formatMessage(record));
        Throwable throwable = record.getThrown();
        if (throwable != null) {
            StringWriter sink = new StringWriter();
            throwable.printStackTrace(new PrintWriter(sink, true));
            buf.append(sink.toString());
        }
        return buf.toString();
    }
    @Override
    public String formatMessage(LogRecord record) {
        return record.getMessage();
    }
}
