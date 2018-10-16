package edu.eci.pdsw.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.pdsw.samples.entities.Cliente;

public interface ClienteDAO {
	public void save(Cliente cl) throws PersistenceException;
	
	public Cliente load(int id) throws PersistenceException;
	
	public List<Cliente> consultarClientes() throws PersistenceException;
}
