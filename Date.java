
public class Date
{
   private int day, month,year;
   
   public Date(int d, int m, int y)
   {
       day = d;
       month = m;
       year = y;
   }
   
   public int getDay() {return day;}
   public int getMonth() {return month;}
   public int getYear() {return year;}
   
   
   public void setDate(int nD, int nM, int nY)
   {
       day = nD;
       month = nM;
       year = nY;
   }
   
   public void setDay(int d) {day = d;}
   public void setMonth(int m) {month = m;}
   public void setYear(int y) {year = y;}
   
   public String toString()
   {
       return day + "/" + month + "/" + year;
   }
   
}
