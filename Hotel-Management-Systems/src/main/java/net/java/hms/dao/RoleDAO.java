//package net.java.hms.dao;
//
//
//import net.java.hms.model.Role;
//
//import java.util.List;
//
//import org.hibernate.HibernateException;
//import org.hibernate.query.Query;
//
//
//public class RoleDAO extends DAO
//{
//	public RoleDAO() {
//	    
//    }
//    
//	public List<Role> getRolesList()
//	{
//		// TODO Auto-generated method stub
//        try {
//            begin();
//            Query<Role> getRolesQuery = getSession().createQuery("from Role", Role.class);
//            List<Role> RolesList = getRolesQuery.getResultList();
//            commit();
//            return RolesList;
//        } catch (HibernateException e) {
//            rollback();
//        }
//		return null;
//	}
//
//}
