package ua.clamor1s.clinic.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.clamor1s.clinic.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/home")
@Slf4j
public class HomeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("HOME Filter");
        User user = (User) ((HttpServletRequest)servletRequest).getSession().getAttribute("user");

        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        ((HttpServletResponse)servletResponse).sendRedirect("login");
    }
}
