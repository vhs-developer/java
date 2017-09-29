/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daniel.interfaces.hibernate_examples.pojos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dan
 */
public class Helper {
    public static String attributeToGetter(String attribute) {
        return attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
    }
    
    public static Vector objectToVector(Object obj, List<String> attribute) {
        Vector vector = new Vector();
        Class<?> c = obj.getClass();
        for (String attribut : attribute) {
            try {
                Method m = c.getDeclaredMethod("get" + attributeToGetter(attribut));
                Object returnValue = m.invoke(obj);
                vector.add(returnValue);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return vector;
    }
}
