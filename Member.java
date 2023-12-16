
public class Member extends Customer
{
    private String code;
    private boolean membership;
    
    public Member(String cN,int d, int m, int y,boolean member,int dt, int f, int s, int t, String code, int payment)
    {
        super(cN,d, m, y, payment,dt,f,s,t);
        this.code = code;
        membership = member;
    }
    
    public String getCode() {return code;}
    public boolean getMembership() {return membership;}
    
    public void setCode(String c) {code = c;}
    public void setMembership(boolean m) {membership = m;}
    
    //processor
    public double calcDiscount()
    {
        double disc = 0.0;
        int yearMember = Integer.parseInt(code.substring(2,4));
        int yearPresent = 23;
        int diffYear = yearPresent - yearMember;
        
        
        if(diffYear < 5)
            disc = 0.10;
        else
            disc = 0.15;
        
        return disc;
        
    }
    
    //printer
    public String toString()
    {
        return super.toString() +
        "\nMember = True" +
        "\nMembership code = " + code;
    }
}
