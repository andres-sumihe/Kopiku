package controller;


import java.util.List;
import javax.faces.bean.ManagedBean;
import model.dao;


@ManagedBean(name = "product")
public class Product  implements java.io.Serializable {

     private int id;
     private String name;
     private String description;
     private float price;
     private String path;

    public Product() {
    }

    public Product(int id, String name, String description, float price, String path) {
       this.id = id;
       this.name = name;
       this.description = description;
       this.price = price;
       this.path = path;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public float getPrice() {
        return this.price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }

    public List<Product> getallrecords(){
        dao pdao=new dao();
        List<Product> prod=pdao.retriveProduct();
        return prod;
    }
    
    

}


