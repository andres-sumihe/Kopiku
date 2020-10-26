package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import model.dao;

@ManagedBean(name = "user")
public class User  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String username;
     private String password;
     private String role;

    public User() {
    }

    public User(String name, String username, String password, String role) {
       this.name = name;
       this.username = username;
       this.password = password;
       this.role = role;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getallrecords(){
        dao udao=new dao();
        List<User> usr=udao.retriveUser();
        return usr;
    }
    
    public void save(){
        dao udao=new dao();
        udao.addUser(this);
    }
    
    public void delete(){    
        dao udao=new dao();
        udao.deleteUser(id);
    }


}


