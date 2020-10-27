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
     public String nameUpdate;
     public String descriptionUpdate;
     public String pathUpdate;
     public float priceUpdate;

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
    
    public String getNameUpdate() {
        return nameUpdate;
    }
    
    public String getPathUpdate() {
        return pathUpdate;
    }
    
    public float getPriceUpdate() {
        return priceUpdate;
    }
    
    public String getDescriptionUpdate() {
        return descriptionUpdate;
    }
    public void setNameUpdate(String name) {
        nameUpdate = name;
    }
    
    public void setPathUpdate(String path) {
        pathUpdate = path;
    }
    
    public void setPriceUpdate(float price) {
        priceUpdate = price;
    }
    
    public void setDescriptionUpdate(String desc) {
        descriptionUpdate = desc;
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
    
    public float getPrice(){
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
    
    public void saveMakanan(){
        dao pdao=new dao();
        setPath("Makanan");
        pdao.addProduct(this);
    }
    
    public void saveMinuman(){
        dao pdao=new dao();
        setPath("Minuman");
        pdao.addProduct(this);
    }
    
    public void delete(){    
        dao pdao=new dao();
        pdao.deleteProduct(id);
    }
    
    public void update(){
        dao pdao=new dao();
        pdao.updateProduct(this);
    }
    
    public List<Product> getbyid(){ 
        dao pdao=new dao();
        List<Product> prod=pdao.getbyID(id);
<<<<<<< HEAD
        this.name=prod.get(0).name;
        this.description=prod.get(0).description;
        this.path=prod.get(0).path;
        this.price=prod.get(0).price;
=======
        name=prod.get(0).name;
        description=prod.get(0).description;
        path=prod.get(0).path;
        price=prod.get(0).price;
>>>>>>> fdfb5b97c41369d17e38fb194ffd4f1fedc6afc4
        return prod;
    }
    
    public void clearVar(){
        this.name = "";
        this.id = 0;
        this.description = "";
        this.price = 0;
        this.path = "";
    }
      
    public void clear(){
        this.id = 0;
        this.name = "";
        this.description = "";
        this.price = 0;
        this.path = "";
    }
}


