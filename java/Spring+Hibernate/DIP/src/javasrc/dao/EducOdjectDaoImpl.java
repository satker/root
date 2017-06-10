package javasrc.dao;

import javasrc.hiber.*;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by Artem on 26.11.2016.
 */
@Repository
public class EducOdjectDaoImpl implements EducOdjectDao{

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<EducOdjectEntity> listEos(Integer id) {

        return sessionFactory.getCurrentSession().createQuery("from EducOdjectEntity where idClassifier="+id)
                .list();
    }
    @SuppressWarnings("unchecked")
    public List<EducOdjectEntity> listEos_all() {

        return sessionFactory.getCurrentSession().createQuery("from EducOdjectEntity")
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<EducOdjectEntity> listEosChild(Integer id) {

        return sessionFactory.getCurrentSession().createQuery("select eo from EducOdjectEntity eo, PositionEoEntity p where eo.id = p.idInEo and p.idEo ="+ id)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<PersonEoEntity> listEoPersonsAll(Integer id) {

        return sessionFactory.getCurrentSession().createQuery("from PersonEoEntity where idEo ="+ id)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<PersonEntity> listEoPersons(Integer id) {

        return sessionFactory.getCurrentSession().createQuery("select p from PersonEntity p, SubdivisionEntity sd, PositionEntity pos, PersonEoEntity peo where peo.idPerson = p.id and peo.idPos = pos.id and peo.idSubdivision = sd.id and peo.idEo ="+ id)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<SubdivisionEntity> listEoSubdiv(Integer id) {

        return sessionFactory.getCurrentSession().createQuery("select sd from PersonEntity p, SubdivisionEntity sd, PositionEntity pos, PersonEoEntity peo where peo.idPerson = p.id and peo.idPos = pos.id and peo.idSubdivision = sd.id and peo.idEo ="+ id)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<PositionEntity> listEoPosit(Integer id) {

        return sessionFactory.getCurrentSession().createQuery("select pos from PersonEntity p, SubdivisionEntity sd, PositionEntity pos, PersonEoEntity peo where peo.idPerson = p.id and peo.idPos = pos.id and peo.idSubdivision = sd.id and peo.idEo ="+ id)
                .list();
    }


    @SuppressWarnings("unchecked")
    public List<PersonEntity> listEoPersons_all() {

        return sessionFactory.getCurrentSession().createQuery("from PersonEntity")
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<SubdivisionEntity> listEoSubdiv_all() {

        return sessionFactory.getCurrentSession().createQuery("from SubdivisionEntity")
                .list();
    }
    @SuppressWarnings("unchecked")
    public List<PositionEntity> listEoPosit_all() {

        return sessionFactory.getCurrentSession().createQuery("from PositionEntity")
                .list();
    }

    public EducOdjectEntity getEoById(int id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EducOdjectEntity.class);
        EducOdjectEntity educOdjectEntity = (EducOdjectEntity) criteria.add(Restrictions.eq("id", id))
                .uniqueResult();
        return educOdjectEntity;
    }

    @Override
    public void update(EducOdjectEntity eo) {
        EducOdjectEntity p = getEoById(eo.getId());
        p.setName(eo.getName());
        sessionFactory.getCurrentSession().update(p);
    }

    public void addEo(EducOdjectEntity eo) {
        EducOdjectEntity p = getEoById(eo.getId());
        sessionFactory.getCurrentSession().save(p);
    }

}
