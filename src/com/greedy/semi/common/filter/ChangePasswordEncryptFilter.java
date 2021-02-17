package com.greedy.semi.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.greedy.semi.common.wrapper.EncryptRequestChangePasswordWrapper;

@WebFilter(urlPatterns = {"/member/passwordChange", "/member/finalResetPwd"})
public class ChangePasswordEncryptFilter implements Filter {

    public ChangePasswordEncryptFilter() {
    }

	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		EncryptRequestChangePasswordWrapper wrapper = new EncryptRequestChangePasswordWrapper(hrequest);
		
		chain.doFilter(wrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
