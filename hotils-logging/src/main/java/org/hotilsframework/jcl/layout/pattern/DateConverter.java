package org.hotilsframework.jcl.layout.pattern;

import org.hotilsframework.jcl.LoggingEvent;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author hireny
 * @className DateConverter
 * @create 2020-02-18 21:08
 */
public class DateConverter extends KeywordConverter {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    @Override
    public String convert(LoggingEvent source) {
        return dateTimeFormatter.format(Instant.ofEpochMilli((source.getTimestamp())).atZone(ZoneId.systemDefault()).toLocalDateTime());
    }
}
