package javasrc.dao;
import javasrc.hiber.ClassifierEntity;

import java.util.List;
/**
 * Created by Artem on 26.11.2016.
 */
public interface ClassifierDao {
    void addClassifier(ClassifierEntity classifiers);

    List<ClassifierEntity> listClassifiers(Integer id);

    List<ClassifierEntity> listAllClassifiers();

    List<ClassifierEntity> listAddClassifiers(String name1, String name2);

    void removeClassifier(Integer classifieridint);

    ClassifierEntity getClassifier(int classifieridint);

    ClassifierEntity getClassifierById(int id);

    void update(ClassifierEntity classifier);
}
