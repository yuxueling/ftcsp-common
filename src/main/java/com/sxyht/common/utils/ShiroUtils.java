package com.sxyht.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {
    /*@Autowired
    private static SessionDAO sessionDAO;*/

    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }
    /**
     * @return user对象，直接强制类型转换为user即可
     */
    public static Object getUser() {
    	return getSubjct().getPrincipal();
    }
    public static void logout() {
        getSubjct().logout();
    }
    /**
	 * 获取session
	 * @return
	 */
	public static Session getSession() {
		return getSubjct().getSession();
	}

    /*public static List<Principal> getPrinciples() {
        List<Principal> principals = null;
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        return principals;
    }*/
}
