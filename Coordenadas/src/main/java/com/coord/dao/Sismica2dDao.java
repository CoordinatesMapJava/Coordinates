package com.coord.dao;

import com.coord.model.Sismica2d;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public interface Sismica2dDao extends JpaRepository <Sismica2d, Long> {

    public Sismica2d findByNome(String nome);
    
}
