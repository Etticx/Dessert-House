    
public class Menu
{
    private int dessertType, flavour, size, topping;
    
    public Menu(int d, int f, int s, int t)
    {
        dessertType = d;
        flavour = f;
        size = s;
        topping = s;
    }
    
    public void setDessertType(int dt) {dessertType = dt;}
    public void setFlavour(int f) {flavour = f;}
    public void setSize(int s) {size = s;}
    public void setTopping(int t) {topping = t;}
    
    
    public double calcCost()
    {
        final double tax = 0.06;
        double cost = 0.0, finalcost = 0.0;
        if(dessertType == 1) /** Cake */
        {
            /**Flavour*/
            if(flavour == 1) // chocolate
            {
                cost += 3.00;
            }
            else if (flavour == 2) // vanilla
            {
                cost += 2.00;
            }
            else if(flavour == 3) // coffee
            {
                cost += 4.00;
            }
            else
                cost = 0;
            
            /**Size*/
            if(size == 1) // small
            {
                cost += 1.00;
            }
            else if (size == 2) // medium
            {
                cost += 2.00;
            }
            else if (size == 3) // large
            {
                cost += 3.00;
            }
            else
                cost = 0;
            
            /**Topping*/
            if(topping == 1) // nuts
            {
                cost += 1.00;
            }
            else if (topping == 2) // Sprinkles
            {
                cost += 1.00;
            }
            else if (topping == 3)//fondant
            {
                cost += 2.00;
            }
            else
                cost = 0;
        } else if (dessertType == 2) /** ice cream */
        {
            /**Flavour*/
            if(flavour == 1) // chocolate
            {
                cost += 2.00;
            }
            else if (flavour == 2) // vanilla
            {
                cost += 1.00;
            }
            else if (flavour == 3)// pistachio
            {
                cost += 3.00;
            }
            else
                cost = 0;
            
            /**Size*/
            if(size == 1) // single scoop
            {
                cost += 1.00;
            }
            else if (size == 2) // double scoop
            {
                cost += 2.00;
            }
            else if (size == 3)// large cup
            {
                cost += 3.00; 
            }
            else
                cost = 0;
            
            /**Topping*/
            if(topping == 1) // sprinkles
            {
                cost += 1.00;
            }
            else if (topping == 2) //choco chips
            {
                cost += 2.00;
            }
            else if (topping == 3) // caramel sauce
            {
                cost += 3.00;
            }
            else
                cost = 0;
        }
    
        
        finalcost = cost + (cost * tax);
        return finalcost;
    }
    
    public String getDessertType()
    {
       if(dessertType == 1)
       {
           return "Cake";  
       }
       else if (dessertType == 2)
       {
           return "Ice Cream";
       }
       else
           return "ERROR";
    }
    
    public String getFlavour()
    {
       if(dessertType == 1)
       {
           if(flavour == 1)
               return "Chocolate";
           else if (flavour == 2)
               return "Vanilla";
           else if (flavour == 3)
               return "Coffee";
           else
               return "ERROR";
       } else if (dessertType == 2)
       {
           if(flavour == 1)
               return "Chocolate";
           else if(flavour == 2)
               return "Vanilla";
           else if (flavour == 3)
               return "Pistachio";
           else
               return "ERROR";
       }
       else
           return "ERROR";
    }
    
    public String getSize()
    {
       if(dessertType == 1)
       {
           if(size == 1)
               return "Small";
           else if (size == 2)
               return "Medium";
           else if (size == 3)
               return "Large";
           else
               return "ERROR";
       } else if (dessertType == 2)
       {
           if(size == 1)
               return "Single Scoop";
           else if(size == 2)
               return "Double Scoop";
           else if (size == 3)
               return "Large Cup";
           else
               return "ERROR";
       }
       else
           return "ERROR";
    }
    
    public String getTopping()
    {
       if(dessertType == 1)
       {
           if(topping == 1)
               return "Nuts";
           else if (topping == 2)
               return "Sprinkles";
           else if (topping == 3)
               return "Fondant";
           else
               return "ERROR";
       } else if(dessertType == 2)
       {
           if(topping == 1)
               return "Sprinkles";
           else if(topping == 2)
               return "Choco Chips";
           else if(topping == 3)
               return "Caramel Sauce";
           else
               return "ERROR";
       }
       else
           return "ERROR";
    }
    
    
    
    public String toString()
    {
        return "Dessert Type = " + getDessertType() +
               "\nFlavour = " + getFlavour() +
               "\nSize = " + getSize() +
               "\nTopping = " + getTopping();
    }
}
