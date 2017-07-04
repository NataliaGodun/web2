package by.htp.library.service.impl;

import by.htp.library.dao.UserDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.dao.factory.DAOFactory;
import by.htp.library.domain.User;
import by.htp.library.service.UserService;
import by.htp.service.exception.ServiceException;

public class UserServiceImpl implements UserService {
	private static final String MESSAGE_WRONG_LOGIN = "Incorrect login!";
	private static final String MESSAGE_WRONG_PASSWORD= "Incorrect password!";
	
	@Override
	public User authorization(String login, String password) throws ServiceException{
		if (login==null||login.isEmpty()){
			throw new ServiceException(MESSAGE_WRONG_LOGIN);
		}
		if (password==null||password.isEmpty()){
			throw new ServiceException(MESSAGE_WRONG_PASSWORD);
		}
		DAOFactory daoObjectFactory=DAOFactory.getInstance();
		UserDAO userDAO=daoObjectFactory.getUserDAO();
		try {
			return userDAO.authorization(login,password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}	
	}

	@Override
	public User registration(String name, String login, String password) throws ServiceException {
		if (login==null||login.isEmpty()){
			throw new ServiceException(MESSAGE_WRONG_LOGIN);
		}
		if (password==null||password.isEmpty()){
			throw new ServiceException(MESSAGE_WRONG_PASSWORD);
		}
		DAOFactory daoObjectFactory=DAOFactory.getInstance();
		UserDAO userDAO=daoObjectFactory.getUserDAO();
		try {
			return userDAO.registration(name,login,password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}	
	}

}
