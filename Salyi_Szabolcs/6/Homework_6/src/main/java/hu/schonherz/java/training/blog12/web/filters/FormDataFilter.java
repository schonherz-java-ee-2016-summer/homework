package hu.schonherz.java.training.blog12.web.filters;

import hu.schonherz.java.training.blog12.web.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Home on 2016. 07. 19..
 */


public class FormDataFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(FormDataFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(
            final ServletRequest servletRequest,
            final ServletResponse servletResponse,
            final FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        if (req.getMethod().equalsIgnoreCase("POST")
                && req.getContentType().contains("form-urlencoded")){

            LOG.info("Parsing POST request body as form data...");
            req.setAttribute("formData", RequestUtils.parseFromBody(req));
        }
    }

    @Override
    public void destroy() {

    }
}
