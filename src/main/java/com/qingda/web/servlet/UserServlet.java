package com.qingda.web.servlet;

import com.qingda.domain.Favorite;
import com.qingda.domain.Holiday;
import com.qingda.domain.User;
import com.qingda.service.FavoriteService;
import com.qingda.service.HolidayService;
import com.qingda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends BaseServlet {

    private FavoriteService favoriteService = new FavoriteService();
    private HolidayService holidayService = new HolidayService();
    /**
     * 退出登录
     *
     * @param request
     * @param response
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 销毁session
        request.getSession().invalidate();
        // 退出成功后,重定向到首页面
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    /**
     * 用户登录
     *
     * @param request
     * @param response
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            //1.获取用户输入的验证的值
            String ucode = request.getParameter("ucode");
            //2.获取Session中的原始验证码
            HttpSession session = request.getSession();
            String scode = (String) session.getAttribute("scode");
            // 为了保证验证码只能使用一次,取出后立即删除该验证码
            session.removeAttribute("scode");
            //3.校验
            if (ucode == null || ucode.length() == 0) {
                // 验证码不可为空
                response.getWriter().print(5);
                return;
            }
            if (!ucode.equalsIgnoreCase(scode)) {
                // 校验不通过
                // 终止程序执行,返回错误的提示信息
                response.getWriter().print(6);
                return;
            }

            String name = request.getParameter("name");
            String passWord = request.getParameter("passWord");
            UserService service = new UserService();
            User user = service.login(name, passWord);
            if (user == null) {
                // 用户名或密码错误  1
                response.getWriter().print(1);
                return;
            }
            // 登录成功
            // 保存登录成功的状态: 将登录成功后的用户信息保存在session中
            session.setAttribute("user", user);
            response.getWriter().print(3);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print(4);
        }
    }

    /**
     * 用户详情页
     *
     * @param request
     * @param response
     */
    public void getuserinfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            UserService service = new UserService();
            user = service.getuser(user.getU_ID());
            // 登录成功
            session.setAttribute("user", user);
            List<Favorite> favoriteList = favoriteService.favoriteListByUser(user.getU_ID());
            List<Holiday> list = new ArrayList<>();
            for (Favorite favorite : favoriteList) {
                list.add(holidayService.findDetailholiday(favorite.getL_id()));
            }
            request.setAttribute("holiday",list);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        request.getRequestDispatcher("myinfo.jsp").forward(request, response);
    }

    /**
     * 用户详情页
     *
     * @param request
     * @param response
     */
    public void edituser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = new User();
        String u_Name = request.getParameter("u_Name");
        String u_Password = request.getParameter("u_Password");
        String u_Location_coun = request.getParameter("u_Location_coun");
        String u_Location_prov = request.getParameter("u_Location_prov");
        String u_Location_city = request.getParameter("u_Location_city");
        String u_DocumentType = request.getParameter("u_DocumentType");
        String u_IDNumber = request.getParameter("u_IDNumber");
        String u_Sex = request.getParameter("u_Sex");
        String u_Birth = request.getParameter("u_Birth");
        user.setU_ID(request.getParameter("u_ID"));
        user.setU_Name(u_Name);
        user.setU_Password(u_Password);
        user.setU_Location_coun(u_Location_coun);
        user.setU_Location_prov(u_Location_prov);
        user.setU_Location_city(u_Location_city);
        user.setU_DocumentType(u_DocumentType);
        user.setU_IDNumber(u_IDNumber);
        user.setU_Sex(u_Sex);
        user.setU_Birth(u_Birth);

        if (user != null && user.getU_Name() != null) {
            UserService service = new UserService();
            service.edituser(user);
            // 登录成功
            session.setAttribute("user", user);
        }
        response.sendRedirect("user?method=getuserinfo");
    }

    /**
     * 用户详情页
     *
     * @param request
     * @param response
     */
    public void chongzhi(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        UserService service = new UserService();
        User user = service.getuser(request.getParameter("id"));
        if (user == null) {
            user = new User();
        }
        BigDecimal add = new BigDecimal(request.getParameter("addprice"));
        BigDecimal uprice = user.getU_price();
        if (uprice != null) {
            uprice = uprice.add(add);
        } else {
            uprice = add;
        }
        user.setU_price(uprice);
        service.addprice(user.getU_ID(), user.getU_price());
        // 登录成功
        session.setAttribute("user", service.getuser(user.getU_ID()));
        response.sendRedirect("user?method=getuserinfo");
    }

    /**
     * 用户注册
     *
     * @param
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = new User();
        String u_Name = request.getParameter("u_Name");
        String u_Password = request.getParameter("u_Password");
        String u_Location_coun = request.getParameter("u_Location_coun");
        String u_Location_prov = request.getParameter("u_Location_prov");
        String u_Location_city = request.getParameter("u_Location_city");
        String u_DocumentType = request.getParameter("u_DocumentType");
        String u_IDNumber = request.getParameter("u_IDNumber");
        String u_Sex = request.getParameter("u_Sex");
        String u_Birth = request.getParameter("u_Birth");
        user.setU_Name(u_Name);
        user.setU_Password(u_Password);
        user.setU_Location_coun(u_Location_coun);
        user.setU_Location_prov(u_Location_prov);
        user.setU_Location_city(u_Location_city);
        user.setU_DocumentType(u_DocumentType);
        user.setU_IDNumber(u_IDNumber);
        user.setU_Sex(u_Sex);
        user.setU_Birth(u_Birth);
        UserService service = new UserService();
        service.register(user);
    }

}

