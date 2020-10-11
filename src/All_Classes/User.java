
package All_Classes;

public class User {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String authority;
    
    public User(String name,String surname,String username,String password,String authority){
        this.name=name;
        this.surname=surname;
        this.username=username;
        this.password=password;
        this.authority=authority;
    }

    public String getUsername() {
        return username;
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
    public String getPassword() {
        return password;
    }

    public String getAuthority() {
        return authority;
    }
    public boolean equals(User u) {
        
        if(this.username.equals(u.getUsername())){
           return true; 
        }
    return false;     
    }
    public boolean controlUserPassword(String password){
            if(this.password.equals(password)){
                return true;
            }
            
        return false;
    }
    
}
