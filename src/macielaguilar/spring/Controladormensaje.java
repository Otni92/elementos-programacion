/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macielaguilar.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author T-101
 */
@Controller
@RequestMapping("/")
public class Controladormensaje {
    //por cada entidad se guenera un controlador 
    @RequestMapping(value="/mensaje",method =RequestMethod.GET,headers={"Accept=application/json"})
    @ResponseBody String buscartodos() throws Exception{
        
    
        //esto va ser optenido a travez de dao mensaje
        /*Mensaje m1=new Mensaje();
        m1.setTitulo("springboot");
        m1.setCuerpo("springboot");
        
        Mensaje m2=new Mensaje();
        m2.setTitulo("Java 3");
        m2.setCuerpo("Esta materia es facil");
         
        Mensaje m3=new Mensaje();
        m3.setTitulo("otniel");
        m3.setCuerpo("tu no vas a pasar ;D");
        
        ArrayList<Mensaje> arreglo=new ArrayList<Mensaje>();
        arreglo.add (m1);
        arreglo.add (m2);
        arreglo.add (m3);
        //Vamos a usar una clase que se llame objetMapper
        ObjectMapper mapper= new ObjectMapper();
        return mapper .writeValueAsString(arreglo);
        */
        
        DAOMensaje dao = new DAOMensaje();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dao.buscarTodos());
    }
    @RequestMapping(value="/mensaje/{id}",method=RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody String buscarPorId(@PathVariable Integer id)throws Exception{
        DAOMensaje dao = new DAOMensaje();
        Mensaje m = dao.buscarPorId(id);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(m);
    }
    
}
