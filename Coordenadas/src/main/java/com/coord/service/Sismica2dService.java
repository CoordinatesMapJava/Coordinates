package com.coord.service;

import com.coord.model.Sismica2d;
import java.util.List;

public interface Sismica2dService {
    
    public List <Sismica2d> getAll();
    
    public Sismica2d save (Sismica2d s);
    
    public Sismica2d getByNome (String nome);
    
}
