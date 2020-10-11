
package All_Classes;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private String tel;
    private static int lastid=0;
    public Customer(String name_, String surname_,String tel_){
        id=lastid++;
        name = name_;
        surname = surname_;
        tel=tel_;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public String getFullname() {
        return name+","+surname;
    }
    public String getTel() {
        return tel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    public boolean equals(Customer c) {
        
        if(this.id==c.getId()){
           return true; 
        }
    return false;     
    }
    public void decrease_id(){
        setId(--lastid);
    }
     
}
