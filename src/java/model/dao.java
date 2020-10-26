package model;

import controller.NewHibernateUtil;
import controller.Product;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class dao {
    public List<Product> retriveProduct(){
        List prod = new ArrayList();
        Product prod1=new Product();
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Product");
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
    
    
}
