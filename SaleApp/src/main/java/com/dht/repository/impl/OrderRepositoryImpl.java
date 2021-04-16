/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.repository.impl;

import com.dht.pojo.Cart;
import com.dht.pojo.OrderDetail;
import com.dht.pojo.SaleOrder;
import com.dht.pojo.User;
import com.dht.repository.OrderRepository;
import com.dht.repository.ProductRepository;
import com.dht.utils.Utils;
import java.math.BigDecimal;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addOrder(Map<Integer, Cart> cart) {
        if (cart == null) {
            return false;
        }

        Session session = this.sessionFactory.getObject().getCurrentSession();

        Map<String, BigDecimal> stats = Utils.getCartStats(cart);

        try {
            SaleOrder order = new SaleOrder();
            order.setAmount(stats.get("totalAmount"));
            order.setUser(session.get(User.class, 6));
            session.save(order);

            cart.values().stream().map(c -> {
                OrderDetail d = new OrderDetail();
                d.setSaleOrder(order);
                d.setQuantity(c.getQuantity());
                d.setPrice(c.getPrice());
                d.setProduct(this.productRepository.getProductById(c.getProductId()));
                return d;
            }).forEachOrdered(d -> {
                session.save(d);
            });
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

}
