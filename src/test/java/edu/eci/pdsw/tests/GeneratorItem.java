/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.tests;
import edu.eci.pdsw.samples.entities.Item;
import static edu.eci.pdsw.tests.GeneratorTypeItem.*;
import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import org.quicktheories.generators.Generate;
import static org.quicktheories.generators.SourceDSL.*;
/**
 *
 * @author Luis
 */
public class GeneratorItem {
    public static Gen<String> nombre(){
        return strings().basicLatinAlphabet().ofLengthBetween(5, 30);
    }
    public static Gen<Integer >id (){
        return integers().from(0).upTo(1500);
    }
    public static Gen<Item> Iteme(){
        return GeneratorTypeItem.tipoItem()
                .zip(id(), nombre(), tarifaxDia(),descripcion(),(tipoItem,id ,nombre,tarifa ,descripcion )
                        -> new Item(tipoItem,id ,nombre,tarifa ,descripcion ));
    }
   public  static Gen<Long>tarifaxDia(){
       return longs().all();
   }
   public static Gen<String>descripcion(){
       return strings().basicLatinAlphabet().ofLengthBetween(10, 50);
   }
}
        