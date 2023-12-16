
public class Order
{
    private Date date;
    private Menu menu;
    
    public Order(int d, int m, int y, int dt, int f, int s, int t)
    {
        date = new Date(d,m,y);
        menu = new Menu(dt,f,s,t);
    }
    
    public Date getDate() {return date;}
    public Menu getMenu() {return menu;}
    
    public void setOrder(int d, int m, int y, int dt, int f, int s, int t)
    {
        date = new Date(d,m,y);
        menu = new Menu(dt,f,s,t);
    }
    
    public void setDate(int d, int m, int y) {date = new Date(d,m,y);}
    public void setMenu(int dt, int f, int s, int t) {menu = new Menu(dt,f,s,t);}
    
    public String toString()
    {
        return "Date Ordered = " + date.toString() + 
                "\n" + menu.toString() + 
                "\nTotal Cost(Including Tax) = RM" + menu.calcCost();
    }
}
