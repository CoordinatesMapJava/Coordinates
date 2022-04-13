package com.coord.serviceimpl;

import com.coord.service.*;
import com.coord.dao.CoordDao;
import com.coord.model.Coord;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "coordRepoService")
public class CoordServiceImpl implements CoordService {
    
    @Autowired
    private CoordDao coordDao;
    
    //@Autowired
    //private Sismica2dDao sismica2dDao;
    
    @Override
    public List<Coord> getAll(){
        System.out.println(coordDao);
        return coordDao.findAll();
    }

    @Override
    public Coord save(Coord s) {
        return coordDao.save(s);
    }
    
//  @Override
//  public List<Coord> getBySismica2d(String nome) {
//      Sismica2d sismica = sismica2dDao.findByNome(nome);
//      if (sismica == null) {
//         return Collections.EMPTY_LIST;
//      }
//      return coordDao.findBySismica2d(sismica);
//  }
    
    @Override
    public List <Coord> getBySismica2dEndsCoord (String nome) {
        
        // Mostrar todos os dados salvos por nome
        return coordDao.findByNome(nome);
        
    }
    
}