package javasrc.service;


import javasrc.dao.CharactDao;
import javasrc.hiber.CharactEntity;
import javasrc.hiber.CharactValueEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Artem on 26.11.2016.
 */
@Service
public class CharactServiceImpl implements CharactService {

    @Autowired
    private CharactDao charactDao;

    @Transactional
    public List<CharactEntity> listCharacts(Integer id) {
        return charactDao.listCharacts(id);
    }

    @Transactional
    public List<CharactEntity> listCharacts_all() {
        return charactDao.listCharacts_all();
    }

    @Transactional
    public List<CharactValueEntity> listCharactValues(Integer id) {
        return charactDao.listCharactValues(id);
    }

    @Transactional
    public List<CharactEntity> listCharactClasses(Integer id) {
        return charactDao.listCharactClasses(id);
    }

    @Transactional
    public CharactEntity getCharactById(int id) {
        return charactDao.getCharactById(id);
    }

    @Transactional
    public void update(CharactEntity charactEntity) {
        charactDao.update(charactEntity);
    }

    @Transactional
    public void addCharact(CharactEntity charactEntity) {
        charactDao.addCharact(charactEntity);
    }

}