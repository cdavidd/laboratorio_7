/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.tests;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.TipoItem;
import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import org.quicktheories.generators.Generate;
import static org.quicktheories.generators.SourceDSL.*;
/**
 *
 * @author Luis
 */
public class GeneratorTypeItem {
     public static Gen<TipoItem>tipoItem(){
        return id().zip(descripcion(),(id, descripcion) -> new TipoItem(id ,descripcion ));
    }
    public static Gen<String>descripcion(){
        return strings().basicLatinAlphabet().ofLengthBetween(10, 50);
    }
    public static Gen<Integer >id (){
        return integers().from(0).upTo(1500);
    }
}
