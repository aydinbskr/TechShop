
package All_Classes;

public class Phone extends Product{

    public Phone(String barkod, String name, double p_price, double s_price, String category, int amount, String description) {
        super(barkod, name, p_price, s_price, category, amount, description);
    }
    
    @Override
    public double calcPrice(){
        return s_price+(s_price*0.18);
    }
    
}
