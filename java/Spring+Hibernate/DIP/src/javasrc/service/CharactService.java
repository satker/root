package javasrc.service;


import javasrc.hiber.CharactEntity;
import javasrc.hiber.CharactValueEntity;

import java.util.List;


/**
 * Created by Artem on 26.11.2016.
 */
public interface CharactService {
    List<CharactEntity> listCharacts(Integer id);
    List<CharactEntity> listCharacts_all();
    List<CharactValueEntity> listCharactValues(Integer id);
    List<CharactEntity> listCharactClasses(Integer id);
    CharactEntity getCharactById(int id);
    void update(CharactEntity charactEntity);
    void addCharact(CharactEntity charactEntity);
}
