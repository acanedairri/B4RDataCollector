package org.irri.utility;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ACañeda on 2016-02-10.
 */
public class DateUtil {

    String date;

    public DateUtil() {

    }

    public String getDate() {

        Date date = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = date.getTime();
        //Passed the milliseconds to constructor of Timestamp class
        Timestamp ts = new Timestamp(time);
        String toreturn=fmt.format(ts);
        return toreturn;
    }


}
