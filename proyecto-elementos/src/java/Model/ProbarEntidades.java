/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author T-101
 */
public class ProbarEntidades {
    public static void main (String[] args){
        try{
        //Paso 1 General el seasion Factory
        SessionFactory fuck=HibernateUtilidades.getSessionFactory();
        Session sesion= fuck.openSession();
        Transaction tranza= sesion.beginTransaction();
        //ahora si veran lo que nunca en su vida en su vida an visto 
        Usuario usuario=new Usuario("martinez", "yomero");
        sesion.save(usuario);
        tranza.commit();
        sesion.close();
            System.out.println("usuario guardado con exito");
    }catch(Exception e){
    }
  }
}