import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class DateRange {
    public static void main(String[] args) {
        List<String> dates = List.of("2023-01-21","2023-01-22","2023-01-23","2023-01-25","2023-01-27");
        String fromDate = "2023-01-23";
        String toDate = "2023-01-27";
        ZoneId zone = ZoneId.of("America/New_York"); // set the time zone to EST

        // convert the input dates to LocalDate objects
        LocalDate fromLocalDate = LocalDate.parse(fromDate);
        LocalDate toLocalDate = LocalDate.parse(toDate);

        // if the current time is after 19:00 EST, consider the fromDate as the next day
        LocalDateTime currentDateTime = LocalDateTime.now(zone);
        if (currentDateTime.getHour() >= 19) {
            fromLocalDate = fromLocalDate.plusDays(1);
        }

        // loop through the list of dates and add the ones that are within the range
        List<String> output = new ArrayList<>();
        for (String date : dates) {
            LocalDate localDate = LocalDate.parse(date);
            if (localDate.isAfter(fromLocalDate) && !localDate.isAfter(toLocalDate)) {
                output.add(date);
            }
        }

        System.out.println(output); // prints ["2023-01-25", "2023-01-27"]
    }
}
