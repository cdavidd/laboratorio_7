package edu.eci.pdsw.sampleprj.dao.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;
import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
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

}
