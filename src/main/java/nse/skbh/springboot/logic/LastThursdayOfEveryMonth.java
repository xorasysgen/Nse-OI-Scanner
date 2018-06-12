package nse.skbh.springboot.logic;

import java.text.*;
import java.util.*;
 
public class LastThursdayOfEveryMonth {
 
    public static List<String>  getNextExpiryOfEveryMonth(){
    	Map<Integer,String> lm=new LinkedHashMap<Integer, String>();
    	List<String> result=new LinkedList<String>();
    	Integer year = Calendar.getInstance().getWeekYear();//to get current year
    	Integer yearNext = Calendar.getInstance().getWeekYear()+1;//to get next  year
        GregorianCalendar c = new GregorianCalendar(year, 0, 1);
        Integer i=0;
        for (String mon : new DateFormatSymbols(Locale.US).getShortMonths()) {
            if (!mon.isEmpty()) {
                Integer totalDaysOfMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                c.set(Calendar.DAY_OF_MONTH, totalDaysOfMonth);
 
                Integer daysToRollBack = (c.get(Calendar.DAY_OF_WEEK) + 1) % 7;
 
                Integer day = totalDaysOfMonth - daysToRollBack;
                c.set(Calendar.DAY_OF_MONTH, --day); // to get thursday
                
                String date=day.toString().concat(mon.toUpperCase()).concat(year.toString());
               // System.out.println(date);
                lm.put(i++,date);
                c.set(year, c.get(Calendar.MONTH) + 1, 1);
            }
        }
        
        
        GregorianCalendar c1 = new GregorianCalendar(yearNext, 0, 1);
        for (String mon : new DateFormatSymbols(Locale.US).getShortMonths()) {
            if (!mon.isEmpty()) {
                Integer totalDaysOfMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                c1.set(Calendar.DAY_OF_MONTH, totalDaysOfMonth);
 
                Integer daysToRollBack = (c1.get(Calendar.DAY_OF_WEEK) + 1) % 7;
 
                Integer day = totalDaysOfMonth - daysToRollBack;
                c1.set(Calendar.DAY_OF_MONTH, --day);// to get thursday
                
                String date=day.toString().concat(mon.toUpperCase()).concat(yearNext.toString());
               // System.out.println(date);
                lm.put(i++,date);
                c1.set(year, c.get(Calendar.MONTH) + 1, 1);
            }
        }
		Integer currentMonth=Calendar.DAY_OF_MONTH;
        result.add(lm.get(currentMonth));
        result.add(lm.get(++currentMonth));
        result.add(lm.get(++currentMonth));
		return result;
        
    }
    
    
}