package javasrc.service;

import javasrc.dao.ClassifierDao;
import javasrc.hiber.ClassifierEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Artem on 26.11.2016.
 */
@Service
public class ClassifierServiceImpl implements ClassifierService {

    @Autowired
    private ClassifierDao classifierDao;

    @Transactional
    public void addClassifier(ClassifierEntity classifiers) {
        classifiers.setId(3);
        classifierDao.addClassifier(classifiers);
    }

    @Transactional
    public List<ClassifierEntity> listClassifiers(Integer id) {

        return classifierDao.listClassifiers(id);
    }

    @Transactional
    public List<ClassifierEntity> listAddClassifiers(String name1, String name2) {

        return classifierDao.listAddClassifiers(name1, name2);
    }

    @Transactional
    public List<ClassifierEntity> listAllClassifiers() {
        return classifierDao.listAllClassifiers();
    }

    @Transactional
    public ClassifierEntity getClassifierById(int id) {
        return classifierDao.getClassifierById(id);
    }

    @Transactional
    public void removeClassifier(Integer classifieridint) {
        classifierDao.removeClassifier(classifieridint);
    }

    @Transactional
    public void update(ClassifierEntity classifier) {
        classifierDao.update(classifier);
    }

}
