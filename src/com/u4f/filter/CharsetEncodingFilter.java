package com.u4f.filter;

/*import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetEncodingFilter implements Filter {
    private String defaultEncode ="UTF-8";

    public void init(FilterConfig config) throws ServletException {
        if(config.getInitParameter("charset")!=null){
            defaultEncode=config.getInitParameter("charset");
        }
    }

    public void destroy() {
    	defaultEncode = null;
    }

    public void doFilter(ServletRequest request, 
    					 ServletResponse response,
    					 FilterChain chain) 
    		throws IOException, ServletException {
        ServletRequest srequest=request;
        srequest.setCharacterEncoding(defaultEncode);
        chain.doFilter(srequest,response);
    }

	
}
*/
