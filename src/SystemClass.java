
import All_Classes.Customer;
import All_Classes.Product;
import All_Classes.Sale;
import All_Classes.User;
import java.util.ArrayList;
import java.util.Date;

public class SystemClass {
    
    private static ArrayList<Sale> sales = new ArrayList<Sale>();
    public static ArrayList<Product> productlist=new ArrayList<Product>();
    private static ArrayList<Customer> myCustomers=new ArrayList<Customer>();
    private static ArrayList<User> users=new ArrayList<User>();
   
    //######### PRODUCT  ##################################
    public static boolean addProduct(Product p){
        if(productindexOf(p)==-1){
             productlist.add(p);
             return true;
        }  
        return false;
    }
     public static boolean updateProduct(String barcode,Product p){
         if(productindexOf(p.getBarkod())==-1){
             productlist.set(productindexOf(barcode),p);
             return true;
         }
        return false;
    }
    public static void removeProduct(String barcode){
       
        productlist.remove(productindexOf(barcode));   
    }
    
    public static int productindexOf(Product p){
        for (int i = 0; i < productlist.size(); i++) {
            if(p.equals(productlist.get(i))){
                return i;
            }   
        }
        return -1;
    }
    public static int productindexOf(String barcode){
        for (int i = 0; i < productlist.size(); i++) {
                if(productlist.get(i).getBarkod().equals(barcode)){
                    return i;
                }
            }
        return -1;
    }
    public static ArrayList<Product> getAllProduct(){
          
        return productlist;
    }
    public static Product getProduct(String barcode){
          
        return productlist.stream().filter(product -> barcode.equalsIgnoreCase(product.getBarkod()))
                                    .findFirst().orElse(null);
    }
    // ########## CUSTOMER  ##########
    public static void addCustomer(Customer c){
        myCustomers.add(c);
    }
    public static void updateCustomer(int index,Customer c){
        
        myCustomers.set(customerindexOf(index),c);
    }
    public static void removeCustomer(int id){
       
        myCustomers.remove(customerindexOf(id));   
    }
    public static int customerindexOf(int id){
        for (int i = 0; i < myCustomers.size(); i++) {
                if(myCustomers.get(i).getId()==id){
                    return i;
                }
            }
        return -1;
    }
    public static Customer searchCustomer(int id){
        for (int i = 0; i < myCustomers.size(); i++) {
                if(myCustomers.get(i).getId()==id){
                    return myCustomers.get(i);
                }
            }
        return null;
    }
    public static ArrayList<Customer> getAllCustomer(){
          
        return myCustomers;
    }
    public static ArrayList<String> getCustomerList(){
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i < myCustomers.size(); i++) {
                list.add(myCustomers.get(i).getName()+","+myCustomers.get(i).getSurname());
            }
        return list;
    }
    public static Customer getCustomer(String text){
          
        return myCustomers.stream().filter(customer -> text.equalsIgnoreCase(customer.getSurname()))
                                    .findFirst().orElse(null);
    }
    public static Customer getCustomer(int index){      
        return myCustomers.get(index);
    }
    // #####################################################
    // ########## USER  ##########
    public static boolean addUser(User u){
        if(userindexOf(u.getUsername())==-1){
             users.add(u);
             return true;
        }  
        return false;
        
    }
    public static boolean updateUser(String username,User u){
        if(userindexOf(u.getUsername())==-1){
             users.set(userindexOf(username),u);
             return true;
         }
        return false;    
    }
    public static void removeUser(String username){
       
        users.remove(userindexOf(username));   
    }
    public static int userindexOf(String username){
        for (int i = 0; i < users.size(); i++) {
                if(users.get(i).getUsername().equals(username)){
                    return i;
                }
            }
        return -1;
    }
    public static User searchUser(String username){
        for (int i = 0; i < users.size(); i++) {
                if(users.get(i).getUsername().equals(username)){
                    return users.get(i);
                }
            }
        return null;
    }
    public static ArrayList<User> getAllUser(){
          
        return users;
    }
    public static ArrayList<String> getUserList(){
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
                list.add(users.get(i).getName()+","+users.get(i).getSurname());
            }
        return list;
    }
    public static User getUser(String text){
          
        return users.stream().filter(user -> text.equalsIgnoreCase(user.getUsername()))
                                    .findFirst().orElse(null);
    }
    public static User getUser(int index){      
        return users.get(index);
    }
    // #####################################################
    
    // ########## SALE  #########################################
    public static void addSale(Sale s){
        sales.add(s);
        for (int i = 0; i < s.getBasket().getBasketitems().size(); i++) {
            int d_number=s.getBasket().getBasketitems().get(i).getAmount();
            s.getBasket().getBasketitems().get(i).getProd().decreaseAmount(d_number);
        }     
    }
    public static void removeSale(int id){
       
        sales.remove(saleindexOf(id));   
    }
    public static int saleindexOf(int id){
        for (int i = 0; i < sales.size(); i++) {
                if(sales.get(i).getId()==id){
                    return i;
                }
            }
        return -1;
    }
    public static Sale getSale(int id){
          
        return sales.stream().filter(sale -> id==sale.getId())
                                    .findFirst().orElse(null);
    }
    public static ArrayList<Sale> getAllSales(Date s_date,Date e_date){
        ArrayList<Sale> output= new ArrayList<>();
        for (int i = 0; i < sales.size(); i++) {
                if(sales.get(i).getS_date().after(s_date) && sales.get(i).getS_date().before(e_date)){
                   
                    output.add(sales.get(i));
                }
                
            }
        return output;
    }
    public static ArrayList<Sale> getAllSales(Date s_date,Date e_date,User seller){
        ArrayList<Sale> output= new ArrayList<>();
        for (int i = 0; i < sales.size(); i++) {
                if(sales.get(i).getS_date().after(s_date) && sales.get(i).getS_date().before(e_date) && sales.get(i).getUser().equals(seller)){
                   
                    output.add(sales.get(i));
                }
                
            }
        return output;
    }
    public static ArrayList<Sale> getAllSales(Date s_date,Date e_date,Customer c){
        ArrayList<Sale> output= new ArrayList<>();
        for (int i = 0; i < sales.size(); i++) {
                if(sales.get(i).getS_date().after(s_date) && sales.get(i).getS_date().before(e_date) && sales.get(i).getCustomer().equals(c)){
                   
                    output.add(sales.get(i));
                }
                
            }
        return output;
    }
    public static ArrayList<Sale> getAllSales(Date s_date,Date e_date,Customer c,User seller){
        ArrayList<Sale> output= new ArrayList<>();
        for (int i = 0; i < sales.size(); i++) {
                if(sales.get(i).getS_date().after(s_date) && sales.get(i).getS_date().before(e_date) && sales.get(i).getCustomer().equals(c)&& sales.get(i).getUser().equals(seller)){
                   
                    output.add(sales.get(i));
                }
                
            }
        return output;
    }
    
    
    //##########################################################
}
