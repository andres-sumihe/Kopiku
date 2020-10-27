package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import model.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    
    public void update(){
        dao pdao=new dao();
        pdao.updateUser(this);
    }
    
    public List<User> getbyuserid(){ 
        dao udao=new dao();
        List<User> usr=udao.getbyuserID(id);
        name=usr.get(0).name;
        username=usr.get(0).username;
        password=usr.get(0).password;
        role=usr.get(0).role;
        return usr;
    }
    
    public boolean checkuser(){
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from User where username= :username and password= :password");
            trans.commit();
            query.setString("username", username);
            query.setString("password", password);
            
            List list = query.list();
            
            if(list.size()==1){
                return true;
            }else{
                return false;
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }
}


