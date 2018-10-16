package edu.eci.pdsw.sampleprj.dao.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.pdsw.samples.entities.TipoItem;
import java.util.List;

public class MyBATISTipoItemDAO implements TipoItemDAO{
	@Inject
	private TipoItemMapper tipoItemMapper;

	@Override
	public void save(String tp) throws PersistenceException {
		try {
			tipoItemMapper.addTipoItem(tp);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al registrar el TipoItem "+tp.toString(),e);
		}
	}

	@Override
	public TipoItem load(int id) throws PersistenceException {
		try{
			return  tipoItemMapper.getTipoItem(id);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar el tipoItem "+id,e);
		}
		
	}

    @Override
    public TipoItem consultarTipoItem(int id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoItem> consultarTiposItem() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
