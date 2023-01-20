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
@WebFilter(urlPatterns = "/checks/*")
@Slf4j
public class CheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("CHECK Filter");
        User user = (User) ((HttpServletRequest)servletRequest).getSession().getAttribute("user");

        if (user != null && !user.getType().equals("doctor")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        ((HttpServletResponse)servletResponse).sendRedirect("home");
    }
}
