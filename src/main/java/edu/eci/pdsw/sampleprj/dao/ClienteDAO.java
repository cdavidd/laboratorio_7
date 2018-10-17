package edu.eci.pdsw.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import java.sql.Date;


public interface ClienteDAO {
	public void save(Cliente cl) throws PersistenceException;
	
	public Cliente load(int id) throws PersistenceException; //
	
	public List<Cliente> consultarClientes() throws PersistenceException; //
        
        public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws PersistenceException; //
        
        public void registrarCliente(Cliente c) throws PersistenceException; //
        
        public void vetarCliente(long docu, boolean estado) throws PersistenceException; //
}
