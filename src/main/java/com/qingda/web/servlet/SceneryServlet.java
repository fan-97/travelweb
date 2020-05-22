package com.qingda.web.servlet;


import com.qingda.domain.PageBean;
import com.qingda.domain.Scenery;
import com.qingda.service.SceneryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SceneryServlet", urlPatterns = "/scenery")
public class SceneryServlet extends BaseServlet {

    public void findAllscenery(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//1.获取请求携带的 当前页面的页码
        int pageNumber = 1;
        try {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        } catch (NumberFormatException e) {
            pageNumber = 1;
        }
        //2.自定义每页显示条数
        int pageSize = 8;
        //3.调用service处理业务逻辑
        SceneryService service = new SceneryService();
        PageBean<Scenery> pb = service.findAllscenery(pageNumber,pageSize);
        //4.将查询结果请求转发到scenery_list.jsp页面,并展示
        request.setAttribute("pb",pb);
        request.getRequestDispatcher("scenery_list.jsp").forward(request,response);
    }
    public void findSceneryById(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        //1.获取请求携带的rid的值
        String c_ID = request.getParameter("c_ID");
        //2.调用service处理业务逻辑
        SceneryService service = new SceneryService();
        Scenery scenery = service.findSceneryById(c_ID);
        //3.请求转发到route_detail.jsp
        request.setAttribute("scenery",scenery);
        request.getRequestDispatcher("scenery_detail.jsp").forward(request,response);
    }

    public void findsceneryByName(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        //1.获取请求携带的 当前页面的页码
        String rname = request.getParameter("rname");
        int pageNumber = 1;
        try {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        } catch (NumberFormatException e) {
            pageNumber = 1;
        }
        //2.自定义每页显示条数
        int pageSize = 8;
        //3.调用service处理业务逻辑
        SceneryService service = new SceneryService();
        PageBean<Scenery> pb = service.findsceneryByName(pageNumber,pageSize,rname);
        //4.将查询结果请求转发到scenery_list.jsp页面,并展示
        request.setAttribute("pb",pb);
        request.getRequestDispatcher("scenery_list.jsp").forward(request,response);
    }



}

