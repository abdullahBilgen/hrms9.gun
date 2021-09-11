package kodlamaio.Hrms.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.core.dataAccess.UserDao;
import kodlamaio.Hrms.core.entities.User;


@Service
public class UserLastIndexManager implements UserLastIndexService{
	
	private UserDao userDao;

	@Autowired
	public UserLastIndexManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public int lastIndex(User user) {
		// TODO Auto-generated method stub
		return this.userDao.findAll().lastIndexOf(user);
	}

}
