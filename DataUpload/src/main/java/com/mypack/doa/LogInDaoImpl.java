package com.mypack.doa;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.loader.criteria.CriteriaQueryTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypack.model.Login;


@Repository
public class LogInDaoImpl implements LoginDao {
	@Autowired
	private SessionFactory sessionFactory;
	
		
			
	public void createRegister(Login login) {
		
		Session session=sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.save(login);
		tx.commit();
		session.close();
		
	}



	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		
		System.out.println("In check login");
		Session session=sessionFactory.openSession();
		boolean userFound=false;
		String sql_query="from Login as l where l.username=? and l.password=?";
		Query query=session.createQuery(sql_query);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List list=query.list();
		if((list!=null) && (list.size()>0)) {
		userFound=true;
		}
		session.close();
		return userFound;
	}
		

	/*public Login getUserName(Login login) {

		Session session=sessionFactory.openSession();
		System.out.println("helos");
		Criteria criteria=null;
		Login log=null;
		try {
		criteria=session.createCriteria(Login.class);
		Criterion  criterion=Restrictions.eq("username", login.getUsername() );
		
		criteria.add(criterion);
		
		criteria.setMaxResults(1);
		log=(Login) criteria.uniqueResult();
		
}catch(Exception e) 
{
	e.printStackTrace();
	
}finally {
		if(session!=null) {
			session.close();
		}
}
	return log;
}
}*/

	/*public Login getUsePassword(Login login) {
		// TODO Auto-generated method stub
		
		
		Session session =sessionFactory.openSession();
		Criteria criteria=null;
		Login log=null;
		try {
		criteria=session.createCriteria(Login.class);
		Criterion  criterion=Restrictions.eq("password", login.getPassword() );
		
		criteria.add(criterion);
		
		criteria.setMaxResults(1);
		log=(Login) criteria.uniqueResult();
		
}catch(Exception e) 
{
	e.printStackTrace();
	
}finally {
		if(session!=null) {
			session.close();
		}
}
		return log;
	
}}*/
}
	