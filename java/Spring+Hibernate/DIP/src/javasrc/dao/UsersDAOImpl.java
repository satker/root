package javasrc.dao;

import javasrc.hiber.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by Artem on 13.11.2016.
 */
@Repository
public class UsersDAOImpl implements UsersDao {
    @Autowired
    private SessionFactory sessionFactory;



    public void addUser(UsersEntity users) {
        sessionFactory.getCurrentSession().save(users);
    }

    @SuppressWarnings("unchecked")
    public List<UsersEntity> listContact() {

        return sessionFactory.getCurrentSession().createQuery("from UsersEntity")
                .list();

    }

    public void removeUser(Integer id) {
        UsersEntity users = (UsersEntity) sessionFactory.getCurrentSession().load(
                UsersEntity.class, id);
        if (null != users) {
            sessionFactory.getCurrentSession().delete(users);
        }

    }

    public UsersEntity getUserByUsername(String name) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UsersEntity.class);
        UsersEntity usersEntity = (UsersEntity) criteria.add(Restrictions.eq("username", name))
                .uniqueResult();
        return usersEntity;
    }

    @Override
    public void updateUser(UsersEntity user) {
        sessionFactory.getCurrentSession().update(user);
    }


}
