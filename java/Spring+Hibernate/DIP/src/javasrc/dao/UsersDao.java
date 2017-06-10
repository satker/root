package javasrc.dao;

import javasrc.hiber.UsersEntity;

import java.util.List;

/**
 * Created by Artem on 13.11.2016.
 */
public interface UsersDao {
    public void addUser(UsersEntity users);

    public List<UsersEntity> listContact();

    public void removeUser(Integer id);


    UsersEntity getUserByUsername(String name);

    void updateUser(UsersEntity user);
}
