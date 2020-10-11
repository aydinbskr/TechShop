
package All_Classes;

public class BasketItem {
   
    private Product prod;
    private int amount;
    
    public BasketItem(Product p, int a){
        prod = p;
        amount = a;
    }
   
    public Product getProd() {
        return prod;
    }

    public void setProd(Product prod) {
        this.prod = prod;
    }

    public int getAmount() {
        return amount;
    }
    public double getBasketItemTotalPrice(){
        return amount*prod.getS_price();
    }
    public double getBasketItemTotalPriceWithPay(){
        return amount*prod.calcPrice();
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    @Override
    public String toString(){
        String output="";
        output+="\nPRODUCT:"+prod.name+
        "  AMOUNT:"+amount+"  PRICE:"+prod.getS_price()+"TL"+"  TOTAL PRICE:"+getBasketItemTotalPrice()+"TL";  
        return output;
    }
}
