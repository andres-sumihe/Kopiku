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
     public float sum =0;
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
    
    public List<Transaksi> getbyMeja(String Meja){
        dao tdao=new dao();
        List<Transaksi> tran = tdao.retriveByMeja(Meja);
        float[] a = new float[tran.size()];
        for(int i = 0; i<tran.size();i++){
            a[i] = tran.get(i).total;
        }
        for(int i=0; i<tran.size(); i++){
            sum = sum + a[i];
         }
        return tran;
    }
    
    public float getSum(){
        return this.sum;
    }
    public void setSum(float sum){
        this.sum = sum;
    }
}