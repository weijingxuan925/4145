package com.example.blog.interceptor;
import com.example.blog.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JingxuanWei
 * @since 2023/2/23
 */
@Service
public class UserInfoInterceptor implements HandlerInterceptor {


    /**
     * 如果用户已经登录，那么就放行，否则就跳转到登录页面
     * @param request 请求
     * @param response 响应
     * @param o 处理器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            return true;
        }
        response.sendRedirect("/admin/login");
        return false;
    }
}
