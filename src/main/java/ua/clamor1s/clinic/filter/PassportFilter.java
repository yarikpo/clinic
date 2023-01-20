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
@WebFilter(urlPatterns = "/passports")
@Slf4j
public class PassportFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("PASSPORT Filter");
        User user = (User) ((HttpServletRequest)servletRequest).getSession().getAttribute("user");

        if (user != null && user.getType().equals("owner")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        ((HttpServletResponse)servletResponse).sendRedirect("home");
    }
}
