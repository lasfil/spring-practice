package com.hungerfool.demomysql.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.hungerfool.demomysql.dao.BaseDao;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


@Transactional
public class BaseDaoImpl<T, ID extends Serializable> implements JpaRepository<T, ID>,  BaseDao<T, ID> {
    
    private static final long serialVersionUID = 1L;

    
    private Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;


    @SuppressWarnings("unchecked")
    public BaseDaoImpl()
    {
        Type type = getClass().getGenericSuperclass();
        Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
        entityClass = (Class<T>) parameterizedType[0];
    }

    @Override
    public T find(ID id)
    {
        if (id != null)
        {
            return entityManager.find(entityClass, id);
        }
        return null;
    }

    @Override
    public T find(ID id, LockModeType lockModeType)
    {
        if (id != null)
        {
            if (lockModeType != null)
            {
                return entityManager.find(entityClass, id, lockModeType);
            }
            else
            {
                return entityManager.find(entityClass, id);
            }
        }
        return null;
    }

    @Override
    public void persist(T entity)
    {
        Assert.notNull(entity);
        entityManager.persist(entity);

    }

    @Override
    public T merge(T entity)
    {
        Assert.notNull(entity);
        return entityManager.merge(entity);
    }

    @Override
    public void remove(T entity)
    {
        Assert.notNull(entity);
        if (entity != null)
        {
            entityManager.remove(entity);
        }
    }

    @Override
    public Query createNativeQuery(String sql)
    {
        if (!StringUtils.isEmpty(sql))
        {
            return entityManager.createNativeQuery(sql);
        }
        return null;
    }

    @Override
    public void refresh(T entity)
    {
        Assert.notNull(entity);
        if (entity != null)
        {
            entityManager.refresh(entity);
        }
    }

    @Override
    public void refresh(T entity, LockModeType lockModeType)
    {
        Assert.notNull(entity);
        if (entity != null)
        {
            if (lockModeType != null)
            {
                entityManager.refresh(entity, lockModeType);
            }
            else
            {
                entityManager.refresh(entity);
            }
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public ID getIdentifier(T entity)
    {
        Assert.notNull(entity);
        if (entity != null)
        {
            return (ID) entityManager.getEntityManagerFactory().getPersistenceUnitUtil()
                    .getIdentifier(entity);
        }
        return null;
    }

    @Override
    public boolean isManaged(T entity)
    {
        Assert.notNull(entity);
        if (entity != null)
        {
            return entityManager.contains(entity);
        }
        return false;
    }

    @Override
    public void detach(T entity)
    {
        Assert.notNull(entity);
        if (entity != null)
        {
            entityManager.detach(entity);
        }
    }

    @Override
    public void lock(T entity, LockModeType lockModeType)
    {
        Assert.notNull(entity);
        Assert.notNull(lockModeType);
        if (entity != null && lockModeType != null)
        {
            entityManager.lock(entity, lockModeType);
        }
    }

    @Override
    public void clear()
    {
        entityManager.clear();
    }

    @Override
    public void flush()
    {
        entityManager.flush();
    }

	@Override
	public Page<T> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<T> findById(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(ID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(ID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends T> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends T> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends T> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAllById(Iterable<ID> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<T> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getOne(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

    
}