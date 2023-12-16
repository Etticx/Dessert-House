
public abstract class Customer
{
   private int payment;
   private String custName;
   private Order order;
   
   public Customer(String cN,int d, int m, int y, int payment,int dt, int f, int s, int t)
   {
       custName = cN;
       order = new Order(d,m,y,dt,f,s,t);
       this.payment = payment;
   }
   
   public String getCustName() {return custName;}
   public Order getOrder() {return order;}
   
   
   public void setCustomerName(String cn) {custName = cn;}
   public void setOrder(int d, int m, int y, int dt, int f, int s, int t)
   {
       order.setOrder(d,m,y,dt,f,s,t);
   }
   public void setPayment(int payment) {this.payment = payment;}

   
   public String getPayment()
   {
       String paymentMethod = null;
       if(payment == 1)
           paymentMethod = "Credit/Debit Card";
       else if(payment == 2)
           paymentMethod = "ShopeePay";
       else if(payment == 3)
           paymentMethod = "TNG eWallet";
       else if (payment == 4)
           paymentMethod = "Cash";
       else 
           paymentMethod = "ERROR";
       return paymentMethod;
   }
   
   public int getPayment2()
   {
       return payment;
   }
   
   public abstract double calcDiscount();
   
   
   public double calcFinalPrice()
   {
       double finalprice = 0.0, price = 0.0;
       
       price = order.getMenu().calcCost();
       finalprice = price - (price * calcDiscount());
       
       return finalprice;
   }
   
   
   
   public String toString()
   {
       return "Customer Name = " + custName +
              "\n" + order.toString() +
              "\nPayment Method = " + getPayment();
   }
   
}
