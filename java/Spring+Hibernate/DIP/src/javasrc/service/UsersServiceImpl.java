package javasrc.service;

import javasrc.dao.UsersDao;
import javasrc.hiber.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Artem on 13.11.2016.
 */

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    private UsersDao usersDao;

    @Transactional
    public void addUser(UsersEntity users) {
        usersDao.addUser(users);
    }

    @Transactional
    public List<UsersEntity> listContact() {

        return usersDao.listContact();
    }

    @Transactional
    public void removeUser(Integer id) {
        usersDao.removeUser(id);
    }


    @Transactional
    public void updateUserData(UsersEntity user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        UsersEntity oldUserData = getUserByUsername(name);
        usersDao.updateUser(oldUserData);
    }

    @Transactional
    public UsersEntity getUserByUsername(String name) {
        return usersDao.getUserByUsername(name);
    }

}
