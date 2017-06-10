package javasrc.dao;
import javasrc.hiber.*;

import java.util.List;
/**
 * Created by Artem on 26.11.2016.
 */
public interface EducOdjectDao {

    List<EducOdjectEntity> listEos(Integer id);

    List<EducOdjectEntity> listEos_all();

    List<EducOdjectEntity> listEosChild(Integer id);

    List<PersonEntity> listEoPersons(Integer id);

    List<SubdivisionEntity> listEoSubdiv(Integer id);

    List<PositionEntity> listEoPosit(Integer id);

    List<PersonEoEntity> listEoPersonsAll(Integer id);

    List<SubdivisionEntity> listEoSubdiv_all();

    List<PositionEntity> listEoPosit_all();

    List<PersonEntity> listEoPersons_all();

    EducOdjectEntity getEoById(int id);

    void update(EducOdjectEntity eo);

    void addEo(EducOdjectEntity eo);
}