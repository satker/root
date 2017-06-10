package javasrc.dao;

import javasrc.hiber.CharactEntity;
import javasrc.hiber.CharactValueEntity;
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
public class CharactDaoImpl implements CharactDao{

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<CharactEntity> listCharacts(Integer id) {

        return sessionFactory.getCurrentSession().createQuery("select ch from CharactEntity ch, CharactValueEntity val where ch.id = val.idCharact and val.idEo = "+id)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<CharactValueEntity> listCharactValues(Integer id) {

        return sessionFactory.getCurrentSession().createQuery("select val from CharactEntity ch, CharactValueEntity val where ch.id = val.idCharact and val.idEo = "+id)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<CharactEntity> listCharactClasses(Integer id) {

        return sessionFactory.getCurrentSession().createQuery("select ch from ClassifierEntity cl, CharactEntity ch, CharactClassEntity chc where cl.id = chc.idClassifier and ch.id = chc.idCharact and chc.idClassifier = "+id)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<CharactEntity> listCharacts_all() {

        return sessionFactory.getCurrentSession().createQuery("from CharactEntity")
                .list();
    }

    public CharactEntity getCharactById(int id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CharactEntity.class);
        CharactEntity charactEntity = (CharactEntity) criteria.add(Restrictions.eq("id", id))
                .uniqueResult();
        return charactEntity;
    }

    @Override
    public void update(CharactEntity charactEntity) {
        CharactEntity p = getCharactById(charactEntity.getId());
        p.setName(charactEntity.getName());
        sessionFactory.getCurrentSession().update(p);
    }

    public void addCharact(CharactEntity charactEntity) {
        CharactEntity p = getCharactById(charactEntity.getId());
        sessionFactory.getCurrentSession().save(p);
    }

}
