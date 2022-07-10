package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandler {

    public static String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(new Date());
    }
}
