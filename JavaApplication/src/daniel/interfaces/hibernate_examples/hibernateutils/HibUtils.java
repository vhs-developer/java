/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daniel.interfaces.hibernate_examples.hibernateutils;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import daniel.interfaces.hibernate_examples.pojos.Artikel;
import daniel.interfaces.hibernate_examples.pojos.Kunde;
import daniel.interfaces.hibernate_examples.pojos.Helper;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author dan
 */
public class HibUtils {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure("hibernateutils/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static List executeQuery(String hql) {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }
    
    public static DefaultTableModel listToModel(List list, String... attribute) {
        // Motivation der Verwendung von Vector beim DefaultTableModel:
        // data = ( ("Daniel", "Meier"), ("Peter", "Schmidt") )
        // columnNames = ( "Vorname", "Nachname" )
        List<String> columns = Arrays.asList(attribute);
        Vector data = new Vector();
        list.forEach(eintrag -> data.add(Helper.objectToVector(eintrag, columns)));
        
        Vector columnNames = new Vector(columns);
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        return model;
    }
    
    public static List<Kunde> getKunden() {
        return executeQuery("select k from Kunde k");
    }

    public static List<Artikel> getArtikel() {
        return executeQuery("select a from Artikel a");
    }
}
