package com.coord.serviceimpl;

import com.coord.service.*;
import com.coord.dao.Sismica2dDao;
import com.coord.model.Sismica2d;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "sismica2dService")
public class Sismica2dServiceImpl implements Sismica2dService{
    
    @Autowired
    private Sismica2dDao sismica2dDao;
    
    public List<Sismica2d> getAll(){
        System.out.println(sismica2dDao);
        return sismica2dDao.findAll();
    }
    
    public Sismica2d getByNome(String nome){
        return sismica2dDao.findByNome(nome);
    }

    @Override
    public Sismica2d save(Sismica2d s) {
        return sismica2dDao.save(s);
    }
    
}
