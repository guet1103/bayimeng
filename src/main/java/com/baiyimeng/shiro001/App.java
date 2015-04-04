package com.baiyimeng.shiro001;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		 //2、得到SecurityManager实例 并绑定给SecurityUtils 
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();  
	    SecurityUtils.setSecurityManager(securityManager);  
	    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
	    Subject subject = SecurityUtils.getSubject();  
	    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "f"); 
	    
	    try {
	    	subject.login(token);
	    	
	    	System.out.println(subject.isAuthenticated()+"------------------------");
	    	
	    }catch (AuthenticationException  e) {
			e.printStackTrace();
		}
	    
	
	    
	    //6、退出  
	    subject.logout();  
    }
}
