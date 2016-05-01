package org.fileupload.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fileupload.bean.LoginBean;

public class LoginFilter implements Filter {

	@Inject
	private LoginBean loginBean;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String contextPath = req.getContextPath();

		if ((loginBean == null || !loginBean.isLoggedIn()) && req.getServletPath().indexOf("login.jsf") < 0) {
			resp.sendRedirect(contextPath + "/login.jsf");
		} else {
			if (req.getRequestURI().indexOf("/login.jsf") > 0 && loginBean.isLoggedIn())
				resp.sendRedirect(contextPath + "/fileUpload.jsf");
			else
				chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig config) throws ServletException {
		// Nothing to do here!
	}

	public void destroy() {
		// Nothing to do here!
	}

}
