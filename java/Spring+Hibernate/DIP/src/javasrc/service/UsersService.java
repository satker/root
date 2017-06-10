package javasrc.service;

import javasrc.hiber.UsersEntity;

import java.util.List;

/**
 * Created by Artem on 13.11.2016.
 */
public interface UsersService {
    void addUser(UsersEntity users);
    List<UsersEntity> listContact();
    void removeUser(Integer hotelidint);
    UsersEntity getUserByUsername(String name);

    void updateUserData(UsersEntity user);
}
