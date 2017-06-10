package javasrc.dao;

import javasrc.hiber.ClassifierEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by Artem on 26.11.2016.
 */
@Repository
public class ClassifierDaoImpl implements ClassifierDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void addClassifier(ClassifierEntity classifiers) {
        sessionFactory.getCurrentSession().save(classifiers);
    }

    @SuppressWarnings("unchecked")
    public List<ClassifierEntity> listAllClassifiers() {
        return sessionFactory.getCurrentSession().createQuery("from ClassifierEntity")
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<ClassifierEntity> listClassifiers(Integer id) {
        return sessionFactory.getCurrentSession().createQuery("from ClassifierEntity where idParent = " + id)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<ClassifierEntity> listAddClassifiers(String name1, String name2) {
        return sessionFactory.getCurrentSession().createQuery("update ClassifierEntity cl SET cl.idParent = (select id from ClassifierEntity where name = " + name2 + ") where cl.id = (select id from ClassifierEntity where name = " + name2 + ")")
                .list();
    }

    @Override
    public void update(ClassifierEntity classifier) {
        ClassifierEntity p = getClassifierById(classifier.getId());
        p.setIdParent(classifier.getIdParent());
        sessionFactory.getCurrentSession().update(p);
    }


    public void removeClassifier(Integer classifieridint) {
        ClassifierEntity classifiers = (ClassifierEntity) sessionFactory.getCurrentSession().load(
                ClassifierEntity.class, classifieridint);
        if (null != classifiers) {
            sessionFactory.getCurrentSession().delete(classifiers);
        }

    }

    public ClassifierEntity getClassifier(int classifieridint) {
        return  (ClassifierEntity) sessionFactory.getCurrentSession().get(
                ClassifierEntity.class, classifieridint);
    }


    public ClassifierEntity getClassifierById(int id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClassifierEntity.class);
        ClassifierEntity classifierEntity = (ClassifierEntity) criteria.add(Restrictions.eq("id", id))
                .uniqueResult();
        return classifierEntity;
    }


}
