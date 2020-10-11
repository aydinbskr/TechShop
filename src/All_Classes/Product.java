
package All_Classes;


public abstract class Product{
    protected String barkod;
    protected String name;
    protected double p_price;
    protected double s_price;
    protected String category;
    protected String description;
    protected int amount;
    public Product(String barkod,String name,double p_price,double s_price,String category,int amount,String description){
        this.barkod=barkod;
        this.name = name;
        this.p_price=p_price;
        this.s_price=s_price;
        this.description=description;
        this.amount=amount;
        this.category=category;
    }

    public String getBarkod() {
        return barkod;
    }

    public String getName() {
        return name;
    }

    public void decreaseAmount(int number) {
        this.amount=this.amount-number;
    }
     public void increaseAmount(int number) {
        this.amount=this.amount+number;
    }
    public double getP_price() {
        return p_price;
    }

    public double getS_price() {
        return s_price;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }
    //ABSTRACT METHOD
    public abstract double calcPrice();
    public boolean equals(Product p){
        if(this.barkod.equals(p.getBarkod())){
            return true;
        }
       return false;
    }
    
}
