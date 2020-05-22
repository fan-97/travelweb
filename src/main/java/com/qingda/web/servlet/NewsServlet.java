package com.qingda.web.servlet;


import com.qingda.domain.News;
import com.qingda.domain.PageBean;
import com.qingda.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewsServlet", urlPatterns = "/news")
public class NewsServlet extends BaseServlet {

    public void findAllNews(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//1.获取请求携带的 当前页面的页码
        int pageNumber = 1;
        try {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        } catch (NumberFormatException e) {
            pageNumber = 1;
        }
        //2.自定义每页显示条数
        int pageSize = 14;
        //3.调用service处理业务逻辑
        NewsService service = new NewsService();
        PageBean<News> pb = service.findAllNews(pageNumber,pageSize);
        //4.将查询结果请求转发到route_list.jsp页面,并展示
        request.setAttribute("pb",pb);
        request.getRequestDispatcher("news_list.jsp").forward(request,response);
    }
    public void findnewsById(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        //1.获取请求携带的rid的值
        String n_ID = request.getParameter("n_ID");
        //2.调用service处理业务逻辑
        NewsService service = new NewsService();
        News news = service.findnewsById(n_ID);
        //3.请求转发到route_detail.jsp
        request.setAttribute("news",news);
        request.getRequestDispatcher("news_detail.jsp").forward(request,response);
    }

}

