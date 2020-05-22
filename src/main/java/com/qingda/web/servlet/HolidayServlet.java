package com.qingda.web.servlet;

import com.qingda.domain.Favorite;
import com.qingda.domain.Holiday;
import com.qingda.domain.PageBean;
import com.qingda.domain.User;
import com.qingda.service.FavoriteService;
import com.qingda.service.HolidayService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HolidayServlet", urlPatterns = "/holiday")
public class HolidayServlet extends BaseServlet {

    private FavoriteService favoriteService = new FavoriteService();

    public void findAllholiday(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //1.获取请求携带的 当前页面的页码
        int pageNumber = 1;
        try {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        } catch (NumberFormatException e) {
            pageNumber = 1;
        }
        //2.自定义每页显示条数
        int pageSize = 4;
        //3.调用service处理业务逻辑
        HolidayService service = new HolidayService();
        PageBean<Holiday> pb = service.findAllHoliday(pageNumber, pageSize);
        //4.将查询结果请求转发到route_list.jsp页面,并展示
        request.setAttribute("pb", pb);
        request.getRequestDispatcher("holiday_list.jsp").forward(request, response);
    }

    public void findDetailholiday(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String l_ID = request.getParameter("l_ID");
        User user = (User) request.getSession().getAttribute("user");
        HolidayService service = new HolidayService();
        Favorite favorite = favoriteService.getFavorite(l_ID,user.getU_ID());
        int flag = 0;
        if (favorite != null) {
            flag = 1;
        }
        request.setAttribute("flag",flag);
        Holiday holiday = service.findDetailholiday(l_ID);
        request.setAttribute("holiday", holiday);
        request.getRequestDispatcher("holiday_detail.jsp").forward(request, response);
    }

}

