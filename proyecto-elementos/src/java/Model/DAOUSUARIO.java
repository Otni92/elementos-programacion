/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author T-101
 */
public class DAOUSUARIO {
    SessionFactory fuck;
    Session sesion;
    Transaction tranza;

    public DAOUSUARIO() {
        fuck = HibernateUtilidades.getSessionFactory();
        sesion=fuck.openSession();
        tranza=sesion.beginTransaction();
    }
    public void serrarTransaccion(){
        sesion.close();
        tranza.commit();
    }
    //Primer operacion crud
    public void guardar(Usuario objeto)throws Exception{
        sesion.persist(objeto);
        serrarTransaccion();
    }
    public void actualizar(Usuario objeto)throws Exception{
    sesion.update(objeto);
    serrarTransaccion();
}
    public void borrar(Usuario onjeto)throws Exception{
        sesion.delete(onjeto);
        serrarTransaccion();
    }
     public Usuario buscarPorId(Integer Id)throws Exception{
         Usuario objeto = (Usuario) sesion.createCriteria(Usuario.class).add(Restrictions.idEq(Id)).uniqueResult();
         serrarTransaccion();
         return objeto;
     }
     public ArrayList<Usuario> buscarTodos()throws Exception{
      ArrayList<Usuario> objeto=   (ArrayList<Usuario>) sesion.createCriteria(Usuario.class).list();
      serrarTransaccion();
      return objeto;
     }
}