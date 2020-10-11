
package All_Classes;

import java.text.DecimalFormat;
import java.util.ArrayList;

 
public class Basket {
    
    private ArrayList<BasketItem> basket = new ArrayList<>();
    private BasketItem item;
    private double basketSum = 0;
    private double basketSumwithPay = 0;
    
    public void addToBasket(Product p, int amount){
            item=new BasketItem(p,amount);
            basket.add(item);
            basketSum+=item.getBasketItemTotalPrice();
            basketSumwithPay+=item.getBasketItemTotalPriceWithPay();
    }
    public void removeBasketitem(String barcode){
       
        basket.remove(basketItemindexOf(barcode));
        basketSum-=item.getBasketItemTotalPrice();
        basketSumwithPay-=item.getBasketItemTotalPriceWithPay();
    }
    public void increaseBasketSum(int index){
        basketSum+=basket.get(index).getBasketItemTotalPrice();
        basketSumwithPay+=item.getBasketItemTotalPriceWithPay();
    }
    public void deccreaseBasketSum(int index){
        basketSum-=basket.get(index).getBasketItemTotalPrice();
        basketSumwithPay-=item.getBasketItemTotalPriceWithPay();
    }
    public void clearBasket(){
       
        basket.clear();   
    }
    public int basketItemindexOf(String barcode){
        for (int i = 0; i < basket.size(); i++) {
                if(basket.get(i).getProd().getBarkod().equals(barcode)){
                    return i;
                }
            }
        return -1;
    }
    public double getBasketSum() {
        return basketSum;
    }
    public double getBasketSumwithPay() {
        return basketSumwithPay;
    }
    public void updateBasketSum() {
        basketSum=0;
        basketSumwithPay = 0;
        for (int i = 0; i < basket.size(); i++) {
              basketSum+=basket.get(i).getBasketItemTotalPrice();  
              basketSumwithPay+=basket.get(i).getBasketItemTotalPriceWithPay();
            }
    }
    
    public void removeItemFromBasket(int index){
        basket.remove(index); 
        basketSum-=item.getBasketItemTotalPrice();
        basketSumwithPay-=item.getBasketItemTotalPriceWithPay();
    }

    public BasketItem getBasketItem() {
        return item;
    }
    public ArrayList<BasketItem> getBasketitems() {
        return basket;
    }
    @Override
    public String toString(){
        DecimalFormat df=new DecimalFormat(".##");
        String output="";
         for (int i = 0; i < basket.size(); i++) {
               output+=basket.get(i).toString();
            }
         output+="\n\nTOTAL:"+df.format(getBasketSum())+"TL"+"\nPAY:"+df.format((basketSumwithPay-basketSum))
                 +"TL"+"\nGENERAL TOTAL:"+df.format(getBasketSumwithPay())+"TL";
        return output;
    }
    
}
