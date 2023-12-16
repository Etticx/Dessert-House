
public class NonMember extends Customer
{
    private boolean discCode;
    private String code;
    public NonMember(String cN, int d, int m, int y, boolean discCode,int dt, int f, int s, int t, String code, int payment)
    {
        super(cN,d,m,y,payment,dt,f,s,t);
        this.discCode = discCode;
        this.code=code; 
    }
    
    public boolean getDiscCode() {return discCode;}
    public String getCode() {return code;}
    
    public void setDiscCode(boolean d) {discCode = d;}
    public void setCode(String c) {code = c;}
    
    
    public double calcDiscount()
    {
        double discfornon = 0.0;
        if(discCode)
        {
            if(code.equalsIgnoreCase("DH41"))
                discfornon = 0.10;
            else if (code.equalsIgnoreCase("DH53"))
                discfornon = 0.20;
            else
                discfornon = 0.0;
        }
        else
            discfornon = 0.0;
        return discfornon;
    }
    
    public String showDisc()
    {
      String actualdisc;
      if(discCode)
      {
          if(code.equalsIgnoreCase("DH41"))
                actualdisc = "10%";
            else if (code.equalsIgnoreCase("DH53"))
                actualdisc = "20%";
            else
                actualdisc = "INVALID";
      }
      else
          actualdisc = "NO DISCOUNT COUPON";
          
      return actualdisc;
    }

    
    public String toString()
    {
        return super.toString() +
               "\nMember = False" +
               "\nDiscount Code = " + code +
               "\nDiscount = " + showDisc();
    }
}
