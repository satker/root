package javasrc.service;


import javasrc.dao.EducOdjectDao;
import javasrc.hiber.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Artem on 26.11.2016.
 */
@Service
public class EducOdjectServiceImpl implements EducOdjectService {

    @Autowired
    private EducOdjectDao educOdjectDao;

    @Transactional
    public List<EducOdjectEntity> listEos(Integer id) {
        return educOdjectDao.listEos(id);
    }

    @Transactional
    public List<EducOdjectEntity> listEos_all() {
        return educOdjectDao.listEos_all();
    }

    @Transactional
    public List<EducOdjectEntity> listEosChild(Integer id) {
        return educOdjectDao.listEosChild(id);
    }

    @Transactional
    public List<PersonEoEntity> listEoPersonsAll(Integer id) {
        return educOdjectDao.listEoPersonsAll(id);
    }

    @Transactional
    public List<PersonEntity> listEoPersons(Integer id) {
        return educOdjectDao.listEoPersons(id);
    }

    @Transactional
    public List<SubdivisionEntity> listEoSubdiv(Integer id) {
        return educOdjectDao.listEoSubdiv(id);
    }
    @Transactional
    public List<PositionEntity> listEoPosit(Integer id) {
        return educOdjectDao.listEoPosit(id);
    }

    @Transactional
    public List<PersonEntity> listEoPersons_all() {
        return educOdjectDao.listEoPersons_all();
    }

    @Transactional
    public List<SubdivisionEntity> listEoSubdiv_all() {
        return educOdjectDao.listEoSubdiv_all();
    }
    @Transactional
    public List<PositionEntity> listEoPosit_all() {
        return educOdjectDao.listEoPosit_all();
    }

    @Transactional
    public EducOdjectEntity getEoById(int id) {
        return educOdjectDao.getEoById(id);
    }

    @Transactional
    public void update(EducOdjectEntity eo) {
        educOdjectDao.update(eo);
    }

    @Transactional
    public void addEo(EducOdjectEntity eo) {
        educOdjectDao.addEo(eo);
    }

}