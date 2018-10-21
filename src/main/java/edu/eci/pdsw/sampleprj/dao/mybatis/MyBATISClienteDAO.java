package edu.eci.pdsw.sampleprj.dao.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;
import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;


public class MyBATISClienteDAO implements ClienteDAO{
    @Inject
    private ClienteMapper clienteMapper;    


    @Override
    public void save(Cliente cli) {
        try {
            clienteMapper.agregarCliente(cli);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar el Cliente "+cli.toString(),e);
        }
    }



    @Override
    public Cliente load(int id) throws PersistenceException {
        try{
            return clienteMapper.consultarCliente(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el item "+id,e);
        }

      }

    @Override
    public List<Cliente> consultarClientes() throws PersistenceException {
        try{
            return clienteMapper.consultarClientes();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error Consultar Clientes");
        }

    }

    @Override
    public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws PersistenceException {
        try{
            clienteMapper.registrarAlquilerCliente(date, docu, item, numdias);
        }catch(PersistenceException ex){
            throw new PersistenceException("Error al registrar alquiler cliente "+docu);
        }
        
    }

    @Override
    public void registrarCliente(Cliente c) throws PersistenceException {
        try{
            clienteMapper.registrarCliente(c);
        }catch(PersistenceException ex){
            throw new PersistenceException("Error al registrar cliente "+c.toString()); 
        }
        
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws PersistenceException {
        try{
            clienteMapper.vetarCliente(docu, estado);
        }catch(PersistenceException ex){
            throw new PersistenceException("Error al vetar cliente "+docu); 
        }
        
    }

    @Override
    public List<ItemRentado> consultarItemsCliente(long idcliente) throws PersistenceException {
        try{
            return clienteMapper.consultarItemsCliente(idcliente);
        }catch(PersistenceException ex){
            throw new PersistenceException("Error al consultar items cliente "+idcliente); 
        }
    }

}
