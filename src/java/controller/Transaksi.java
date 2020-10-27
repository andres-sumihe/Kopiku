package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import model.dao;

@ManagedBean(name = "transaksi")
public class Transaksi  implements java.io.Serializable {

     private Integer id;
     private int jumlah;
     private String product;
     private float total;
     private String tablenum;
    public Transaksi() {
    }

    public Transaksi(int jumlah, String product, float total) {
       this.jumlah = jumlah;
       this.product = product;
       this.total = total;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getJumlah() {
        return this.jumlah;
    }
    
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    public String getProduct() {
        return this.product;
    }
    
    public void setProduct(String product) {
        this.product = product;
    }
    public float getTotal() {
        return this.total;
    }
    
    public void setTotal(float total) {
        this.total = total;
    }
    public String getTablenum() {
        return this.tablenum;
    }
    
    public void setTablenum(String tablenum) {
        this.tablenum = tablenum;
    }
    public List<Transaksi> getallrecords(){
        dao tdao=new dao();
        List<Transaksi> tran=tdao.retrieveTransaksi();
        return tran;
    }
    
    public void save(){
        dao tdao=new dao();
        tdao.addTransaksi(this);
    }

}