package controller;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import model.dao;
@ManagedBean(name = "product")
public class Product  implements java.io.Serializable {
     private int id;
     private String name;
     private String description;
     private float price;
     private String path;
     public String makananPilih;
     public String minumanPilih;
     public String[] KeranjangNama;
     public int[] KeranjangHarga = new int[100];
     public String Meja;
     
     int indexx =0;
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
    
    public String getMeja() {
        return this.Meja;
    }
    
    public void setMeja(String name) {
        this.Meja = name;
    } 
    public static List<Product> getallrecordsMakanan(){
        dao pdao=new dao();
        List<Product> prod=pdao.retriveProductMakanan();
        return prod;
    }
    public static List<Product> getallrecordsMinuman(){
        dao pdao=new dao();
        List<Product> prod=pdao.retriveProductMinuman();
        return prod;
    }
    

    public void saveMakanan(){
        dao pdao=new dao();
        setPath("Makanan");
        pdao.addProduct(this);
        clear();
    }
    
    public void saveMinuman(){
        dao pdao=new dao();
        setPath("Minuman");
        pdao.addProduct(this);
        clear();
    }

    public void delete(){    
        dao pdao=new dao();
        pdao.deleteProduct(id);
        clear();
    }

    public void update(){
        dao pdao=new dao();
        pdao.updateProduct(this);
        clear();
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

    public String getMakananPilih() {
        return this.makananPilih;
    }
    public void setMakananPilih(String makananPilih) {
        this.makananPilih = makananPilih;
    }
    
    public String getMinumanPilih() {
        return this.minumanPilih;
    }
    public void setMinumanPilih(String makananPilih) {
        this.minumanPilih = makananPilih;
    }
   
    
    
    public String[] getKeranjangNama() {
        return KeranjangNama;
    }
    public void setKeranjangNama(String[] nama) {
        this.KeranjangNama = nama;
    }
    
    public void tambahKeKeranjang(){
        String[] a = makananPilih.split(",");
        String[] b = minumanPilih.split(",");
        Transaksi tr = new Transaksi();
        tr.setJumlah(1);
        tr.setTablenum(this.Meja);
        tr.setProduct(a[0]+", "+b[0]);
        tr.setTotal(Float.parseFloat(a[1])+Float.parseFloat(b[1]));
        tr.save();
    }
    
    
    public static Map<String,Object> makanan2value;
    static {
        makanan2value = new LinkedHashMap<String,Object>();
        minuman2value = new LinkedHashMap<String,Object>();
        List<Product> prod= getallrecordsMakanan();
            makanan2value.put("Tidak Ada", "Tidak Ada"); 
            for (int i =0; i < prod.size(); i++) {
                makanan2value.put(prod.get(i).name+" - "+prod.get(i).price, prod.get(i).name+','+prod.get(i).price); 
            }
    }
    
    public Map<String,Object> getMakananPilihValue() {
		return makanan2value;
	}
    public static Map<String,Object> minuman2value;
    static {
        minuman2value = new LinkedHashMap<String,Object>();
        List<Product> prod= getallrecordsMinuman();
            minuman2value.put("Tidak Ada", "Tidak Ada"); 
            for (int i =0; i < prod.size(); i++) 
            minuman2value.put(prod.get(i).name+" - "+prod.get(i).price, prod.get(i).name+','+prod.get(i).price); 
    }
    
    public Map<String,Object> getMinumanPilihValue() {
		return minuman2value;
    }
    
}
    
    
    