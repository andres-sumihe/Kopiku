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
    public List<Product> getallrecordsMakanan(){
        dao pdao=new dao();
        List<Product> prod=pdao.retriveProductMakanan();
        return prod;
    }
    public List<Product> getallrecordsMinuman(){
        dao pdao=new dao();
        List<Product> prod=pdao.retriveProductMinuman();
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
        name=prod.get(0).name;
        description=prod.get(0).description;
        path=prod.get(0).path;
        price=prod.get(0).price;
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
    
    
    