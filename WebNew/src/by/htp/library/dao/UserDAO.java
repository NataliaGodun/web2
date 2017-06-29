package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.domain.User;

public interface UserDAO {
	User authorization(String login, String password) throws DAOException;

	User registration(String name, String login, String password) throws DAOException;
}
