import java.io.*;
import java.util.*;
import java.text.*;
public class Main
{
    public static void main(String [] args)
    {
        try
        {
           FileReader fr = new FileReader("CustomerOrder.txt");
           BufferedReader br = new BufferedReader(fr);
           
           FileWriter fw = new FileWriter("OutputOrder.txt");
           PrintWriter pw = new PrintWriter(fw);
           
           int i = 0, dessertType,flavor,size,topping, payment, day, month, year;
           String custName, inData = null, hasMember, code, hasDiscCode,discCode;
           boolean member = false, discountCode = false;
           
           Scanner sc = new Scanner(System.in);
           sc.useDelimiter("\n");
           DecimalFormat df = new DecimalFormat("0.00");
           
           Customer [] customer = new Customer[20];
           
           while((inData = br.readLine()) != null)
           {
               StringTokenizer st = new StringTokenizer(inData, ";");
               custName = st.nextToken();
               day = Integer.parseInt(st.nextToken());
               month = Integer.parseInt(st.nextToken());
               year = Integer.parseInt(st.nextToken());
               dessertType = Integer.parseInt(st.nextToken());
               flavor = Integer.parseInt(st.nextToken());
               size = Integer.parseInt(st.nextToken());
               topping = Integer.parseInt(st.nextToken());
               payment = Integer.parseInt(st.nextToken());
               hasMember = st.nextToken();
               if(hasMember.equalsIgnoreCase("YES"))
               {
                   member = true;
               } else if (hasMember.equalsIgnoreCase("NO"))
               {
                   member = false;
               }
            
               
               if(member)
               {
                   code = st.nextToken();
                   customer[i] = new Member(custName,day,month,year,member,dessertType,flavor,size,topping,code,payment);
               }
               else
               {
                   hasDiscCode = st.nextToken();
                   if(hasDiscCode.equalsIgnoreCase("YES"))
                   {  
                       discountCode = true;
                       discCode = st.nextToken();
                   } 
                   else
                   {
                       discountCode = false;
                       discCode = "NONE";
                   }
                   customer[i] = new NonMember(custName,day,month,year,discountCode,dessertType,flavor,size,topping,discCode,payment);
               }
               
               
               i++;
               
           }
           
           /**Process 1: calculate for Member and Non-member then display details*/
           double price = 0.0, totprice = 0.0;
           pw.println("=============DETAILS OF MEMBER AND NON-MEMBER================");
           for(int x = 0; x < customer.length; x++)
           {
               
               pw.println(customer[x].toString() + "\nFinal Price(After Discount) = RM" + df.format(customer[x].calcFinalPrice()) + "\n");
           }
           
           /**Process 2: calculate total price for each payment method*/
           pw.println("\n===============TOTAL PRICE FOR EACH PAYMENT METHODS==================");
           double price1 = 0.0, price2 = 0.0, price3 = 0.0, price4 = 0.0;
           for(int y = 0; y < customer.length; y++)
           {
               int p = customer[y].getPayment2();
               double finalprice = customer[y].calcFinalPrice();
               
               if(p == 1)
                   price1 += finalprice;
               else if(p == 2)
                   price2 += finalprice;
               else if(p == 3)
                   price3 += finalprice;
               else
                   price4  += finalprice;
           }
           pw.println("Credit/Debit Card = RM" + df.format(price1));
           pw.println("Shopeepay = RM" + df.format(price2));
           pw.println("TNG eWallet = RM" + df.format(price3));
           pw.println("Cash = RM" + df.format(price4));
           
           
           /** Process 3: Searching and updating customer name */
           System.out.print("Enter the customer name to update: ");
           String nameToUpdate = sc.next();
           System.out.print("Enter the new customer name: ");
           String newCustName = sc.next();

           boolean found = false;
           int b = 0;
           while (b < customer.length && !found) {
                
                if (customer[b].getCustName().equalsIgnoreCase(nameToUpdate)) {
                    customer[b].setCustomerName(newCustName);
                    found = true;
                }
                else
                    b++;
            }
            
           pw.println("\n================SEARCHING AND UPDATING CUSTOMER NAME=======================");
           pw.println("Before: " + "\nName to be search = " + nameToUpdate);
           pw.println("\nAfter: ");
           if (found)
            {
                System.out.println(customer[b].toString());
                pw.println(customer[b].toString());
            }

           if (!found) {
             System.out.println("Customer not found!");
             pw.println("Customer not found!");
            }
           
           
           /** Process 4: calculating total price for non member that uses discount code only */
           double totpricenon = 0.0;
           for(int x = 0; x < customer.length; x++)
           {
               if(customer[x] instanceof NonMember)
               {
                   NonMember non = (NonMember)customer[x];
                   if(non.getDiscCode())
                       totpricenon += non.calcFinalPrice();
               }
           }
           pw.println("\n===========TOTAL PRICE FOR NON MEMBER THAT USES DISCOUNT CODE=============");
           pw.println("Total Price = RM" + df.format(totpricenon));
           
           
           /**Process 5: Total member customer who have been member for at least 2 years*/
           int countmem = 0;
           pw.println("\n========TOTAL MEMBER WHO HAVE BEEN MEMBER FOR AT LEAST 2 YEAR=============");
           for(int z = 0; z < customer.length; z++)
           {
               if(customer[z] instanceof Member)
               {
                   Member mem = (Member)customer[z]; //DH2021
                   int yearmem = Integer.parseInt(mem.getCode().substring(2,3));
                   yearmem = 23 - yearmem;
                   if(yearmem >= 2)
                       countmem++;
               }
           }
           pw.println("Total Member = " + countmem);
           
           
           /**Process 6: Total Nonmember who uses Discount Code that received 20% off*/
           int countnon20 = 0;
           pw.println("\n=========TOTAL NON-MEMBER WHO GOT 20% OFF USING DISCOUNT CODE==============");
           for(int k = 0; k < customer.length; k++)
           {
               if(customer[k] instanceof NonMember)
               {
                   NonMember nonmem = (NonMember)customer[k];
                   if(nonmem.getDiscCode())
                   {
                       if(nonmem.getCode().substring(2,4).equals("53"))
                           countnon20++;
                   }
               }
           }
           pw.println("Total Non-member = " + countnon20);
           
           /**Process 7: Total Nonmember who uses Discount Code that received 10% off*/
           int countnon10 = 0;
           pw.println("\n=========TOTAL NON-MEMBER WHO GOT 10% OFF USING DISCOUNT CODE==============");
           for(int k = 0; k < customer.length; k++)
           {
               if(customer[k] instanceof NonMember)
               {
                   NonMember nonmem = (NonMember)customer[k];
                   if(nonmem.getDiscCode())
                   {
                       if(nonmem.getCode().substring(2,4).equals("41"))
                           countnon10++;
                   }
               }
           }
           pw.println("Total Non-member = " + countnon10);
           
           
           br.close();
           pw.close();
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println(fnfe.getMessage());
        }
        catch(IOException io)
        {
            System.out.println(io.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
