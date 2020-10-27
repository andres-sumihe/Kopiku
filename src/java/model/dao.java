package model;

import controller.NewHibernateUtil;
import controller.Product;
import controller.Transaksi;
import controller.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class dao {
    public List<Product> retriveProductMakanan(){
        List prod = new ArrayList();
        Product prod1=new Product();
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Product where path='Makanan'");
            prod=query.list();
            trans.commit();   
        }
        catch(Exception e)
        {
            
        }
        return prod;
    }
    
    public List<Product> retriveProductMinuman(){
        List prod = new ArrayList();
        Product prod1=new Product();
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Product where path='Minuman'");
            prod=query.list();
            trans.commit();   
        }
        catch(Exception e)
        {
            
        }
        return prod;
    }
    public List<Transaksi> retriveByMeja(String meja){
        List prod = new ArrayList();
        Transaksi prod1=new Transaksi();
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Transaksi where tablenum= :meja");
            query.setString("meja", meja);
            prod=query.list();
            trans.commit();   
        }
        catch(Exception e)
        {
            
        }
        return prod;
    }

    public void addProduct(Product product){
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.save(product);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void deleteProduct(int id){
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Product prod=(Product)session.load(Product.class, new Integer(id));
            session.delete(prod);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public List<Product> getbyID(int sno){
        Product product=new Product();
        List<Product> prod1=new ArrayList();
       
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Product where id= :id");
            query.setInteger("id", sno);
            product=(Product)query.uniqueResult();
            prod1=query.list();
            trans.commit();
        }catch(Exception e){
            
        }
        return prod1;
    }
    
    public void updateProduct(Product product){
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(product);
            trans.commit();
        }catch(Exception e){
            
        }
    }
    
    public List<Transaksi> retrieveTransaksi(){
        List tran = new ArrayList();
        Transaksi tran1=new Transaksi();
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Transaksi");
            tran=query.list();
            trans.commit();   
        }
        catch(Exception e)
        {
            
        }
        return tran;
    }
    
    public void addTransaksi(Transaksi transaksi){
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.save(transaksi);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public List<User> retriveUser(){
        List usr = new ArrayList();
        User usr1=new User();
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from User");
            usr=query.list();
            trans.commit();   
        }
        catch(Exception e)
        {
            
        }
        return usr;
    }
    
    public void addUser(User user){
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.save(user);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void deleteUser(int id){
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            User usr=(User)session.load(User.class, new Integer(id));
            session.delete(usr);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public List<User> getbyuserID(int sno){
        User usr=new User();
        List<User> usr1=new ArrayList();
       
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans=session.beginTransaction();
            Query query=session.createQuery("from User where id= :id");
            query.setInteger("id", sno);
            usr=(User)query.uniqueResult();
            usr1=query.list();
            trans.commit();
        }catch(Exception e){
            
        }
        return usr1;
    }
    
    public void updateUser(User user){
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(user);
            trans.commit();
        }catch(Exception e){
            
        }
    }
    
    
}
