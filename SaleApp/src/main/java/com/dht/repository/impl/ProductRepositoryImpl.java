/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.repository.impl;

import com.dht.pojo.Category;
import com.dht.pojo.Product;
import com.dht.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    public List<Product> getProductBase(String[] args, ProductChecker c) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root root = query.from(Product.class);
        query.select(root);

        query = c.getWhere(builder, query, root, args);

        Query q = session.createQuery(query);
        return q.getResultList();

    }

    @Override
    @Transactional
    public List<Product> getProducts(String kw) {
        return getProductBase(new String[]{kw}, (builder, query, root, args) -> {
            Predicate p = builder.like(root.get("name").as(String.class),
                    String.format("%%%s%%", args[0]));
            query = query.where(p);

            return query;
        });
    }

    @Override
    @Transactional
    public List<Product> getProducts(BigDecimal fromPrice, BigDecimal toPrice) {
        return getProductBase(new String[]{String.valueOf(fromPrice),
            String.valueOf(toPrice)},
                (builder, query, root, args) -> {

                    Predicate p = builder.between(root.get("price").as(BigDecimal.class),
                            new BigDecimal(args[0]), new BigDecimal(args[1]));
                    query = query.where(p);

                    return query;
                });
    }

    public List<Object[]> getStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rootP = query.from(Product.class);
        Root rootC = query.from(Category.class);
        query = query.where(builder.equal(rootP.get("category"), rootC.get("id")));

        query.multiselect(rootC.get("name").as(String.class),
                builder.count(rootP.get("name").as(String.class)),
                builder.max(rootP.get("price").as(BigDecimal.class)),
                builder.min(rootP.get("price").as(BigDecimal.class)),
                builder.avg(rootP.get("price").as(BigDecimal.class)));

        query = query.groupBy(rootC.get("name").as(String.class));

        Query q = session.createQuery(query);

        return q.getResultList();

    }

    @Override
    @Transactional
    public boolean deleteProduct(int productId) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            Product p = session.get(Product.class, productId);
            session.delete(p);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    @Transactional
    public boolean addOrUpdateProduct(Product product) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (product.getId() > 0)
                s.update(product);
            else
                s.save(product);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    } 

    @Override
    @Transactional
    public Product getProductById(int productId) {
        return this.sessionFactory.getObject().getCurrentSession().get(Product.class, productId);
    }

}

interface ProductChecker {

    CriteriaQuery getWhere(CriteriaBuilder builder, CriteriaQuery q, Root root, String[] args);
}
