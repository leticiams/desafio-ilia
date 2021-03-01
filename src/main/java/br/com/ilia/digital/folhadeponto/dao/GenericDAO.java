package br.com.ilia.digital.folhadeponto.dao;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class GenericDAO {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EntityManager entityManager;

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

}


