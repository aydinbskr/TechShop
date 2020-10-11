
package All_Classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sale implements Receipt{
    private int id;
    private Customer customer;
    private User user;
    private Basket basket;
    private String cashorcredit;
    private Date s_date;
    private static int lastid=0;

    public Sale(Customer customer,User user,String cashorcredit,Basket basket){
        id=lastid++;
        this.customer=customer;
        this.user=user;
        this.cashorcredit=cashorcredit;
        this.basket=basket;
        s_date=new Date();
        
    }

    public int getId() {
        return id;
    }

    public String getCashorcredit() {
        return cashorcredit;
    }


    public Basket getBasket() {
        return basket;
    }

    public Customer getCustomer() {
        return customer;
    }

    public User getUser() {
        return user;
    }
    

    public Date getS_date() {
        return s_date;
    }
    
    public String displayDate(){
        DateFormat df=new SimpleDateFormat("dd.MM.yyyy");
        return df.format(s_date);
    }
    public String displayReceipt(){
        String output="";
        output+="SALE ID:"+id+"  PAYMENT TYPE:"+getCashorcredit()+"  DATE:"+
                displayDate()+"\nCUSTOMER:"+customer.getFullname()+
                "\n"+basket.toString();
        return output;
    }
    
}
