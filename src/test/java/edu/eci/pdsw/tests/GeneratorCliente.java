/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.tests;
import edu.eci.pdsw.samples.entities.Cliente;
import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import org.quicktheories.generators.Generate;
import static org.quicktheories.generators.SourceDSL.*;
/**
 *
 * @author Luis
 */

public class GeneratorCliente {
    public static Gen<String> nombre(){
        return strings().basicLatinAlphabet().ofLengthBetween(5, 30);
    }
    public static Gen<Long >documento(){
        return longs().all();
    }
    public static Gen<Cliente> cliente(){
        return nombre().zip(documento(), strings().numericBetween(3000000,3999999), direccion(), mail(),(nombre, documento, telefono, direccion, email) -> new Cliente(nombre, documento, telefono, direccion, email));
    }
   /**public static Gen<String >telefono(){
        return strings().numericBetween(3000000,3999999);
    }*/
   public  static Gen<String>direccion(){
       return strings().basicLatinAlphabet().ofLengthBetween(5, 30);
   }
   public static Gen<String>mail(){
       return strings().basicLatinAlphabet().ofLengthBetween(5, 30);
   }
   
}
