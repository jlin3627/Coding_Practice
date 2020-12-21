
//Zelle formula
//https://en.wikipedia.org/wiki/Zeller%27s_congruence

/*class Solution
{
    public String dayOfTheWeek(int day, int month, int year) 
    {
        // 1 Jan 1971 (when the interval starts) is a Friday, start day of the weeks on a Friday
        String[] dayWeek = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        // Initialize days of the months
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // check if year is leap and change the day of the corresponding month
        if (isLeap(year))
            monthDays[1] = 29;
        int sum = 0;
        // Sum all past years
        for (int i=1971; i<year; i++){
            if (isLeap(i)) {
                sum += 366;
            } else {
                sum += 365;
            }
        }
        // Sum all past months only (hence month-1)
        for (int i=0; i<month-1; i++){
                sum += monthDays[i];
        }
        // Sum days passed but not the current day (hence day-1)
        sum += day -1;
        // Remainder of Division of Sum by 7 is the extra days you need to add to Friday
        return dayWeek[sum%7];
    }

    // Check if year is leap
    public boolean isLeap(int year)
    {
        if (year % 4 == 0) 
        {
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    return true;
                else
                   return false;
            } else
                return true;
        } 
        else 
        {
           return false;
        }
    }
}*/

/*class Solution
{
    public String dayOfTheWeek(int day, int month, int year) 
    {
        // 1 Jan 1971 (when the interval starts) is a Friday, start day of the weeks on a Friday
        String[] dayWeek = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        // Initialize days of the months
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // check if year is leap and change the day of the corresponding month
        if (isLeap(year))
            monthDays[1] = 29;
        int sum = 0;
        // Sum all past years
        for (int i=1971; i<year; i++)
        {
            if (isLeap(i)) {
                sum += 366;
            } else {
                sum += 365;
            }
        }
        // Sum all past months only (hence month-1)
        for (int i=0; i<month-1; i++){
                sum += monthDays[i];
        }
        // Sum days passed but not the current day (hence day-1)
        sum += day -1;
        // Remainder of Division of Sum by 7 is the extra days you need to add to Friday
        return dayWeek[sum%7];
    }

    // Check if year is leap
    public boolean isLeap(int year)
    {
        if (year % 4 == 0) 
        {
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    return true;
                else
                   return false;
            } else
                return true;
        } 
        else 
        {
           return false;
        }
    }
}*/

/*class Solution
{
    String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public String dayOfTheWeek(int d, int m, int y) {
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        int c = y / 100;
        y = y % 100;
        int w = (c / 4 - 2 * c + y + y / 4 + 13 * (m + 1) / 5 + d - 1) % 7;
        return days[(w + 7) % 7];
    }
}*/

/*class Solution
{
    public String dayOfTheWeek(int day, int month, int year) {
        String[] daysInWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] DaysByMonthMod7 = {0,3,2,5,0,3,5,1,4,6,2,4}; // Jan: 0, Feb: 31%7=3, Mar: 58%7=2, Apr: 89%7=5, etc
        if(month < 3) year -= 1; // 3
        return daysInWeek[(year + (year/4 - year/100 + year/400) + DaysByMonthMod7[month-1] + day) % 7]; // (year*365)%7 = year. Add the leap year days. Add extra month days. Add day.
    }
}*/

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        return java.time.LocalDate.of(year, month, day).getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.US); 
    }
}