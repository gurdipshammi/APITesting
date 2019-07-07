package tajawal.qa.automation.api.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @author Gurdip, July 6, 2019
 */
public class CalDate {

    public static String getFutureDate(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        System.out.println("Current Date: "+sdf.format(cal.getTime()));
        cal.add(Calendar.DATE, days);
        String newDate = sdf.format(cal.getTime());
        return newDate;
    }
}