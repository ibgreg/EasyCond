package br.com.easycond.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.easycond.util.HibernateUtil;

@WebFilter(urlPatterns = {"*.jsf"})
public class HibernateFilter implements Filter {

	private SessionFactory sf;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.sf = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		Session currentSession = this.sf.getCurrentSession();
		
		Transaction transaction = null;
		
		try {
			transaction = currentSession.beginTransaction();
			chain.doFilter(servletRequest, servletResponse);
			transaction.commit();
			
			if(currentSession.isOpen()) {
				currentSession.close();
			}
		} catch (Throwable e) {
			try {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
			throw new ServletException(e);
		}
	}
	
	@Override
	public void destroy() {
	}

}
