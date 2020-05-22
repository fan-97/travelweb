package com.qingda.web.servlet;


import com.mysql.jdbc.StringUtils;
import com.qingda.domain.Holiday;
import com.qingda.domain.Participation;
import com.qingda.service.HolidayService;
import com.qingda.service.ParticipationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ParticipationServlet", urlPatterns = "/participation")
public class ParticipationServlet extends BaseServlet {

    public void findparticipationByName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        ParticipationService participationService = new ParticipationService();
        List<Participation> participationList = participationService.findparticipationByName(username);
        if (participationList.size()==0) {
            response.sendRedirect("error.jsp");
            return;
        }
        HolidayService holidayService = new HolidayService();
        List<Holiday> list = holidayService.findSomeHoliday(participationList);
        request.setAttribute("list",list);
        request.getRequestDispatcher("myfavorite_list.jsp").forward(request,response);
    }
    public void join(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String l_Theme = request.getParameter("l_Theme");
        String u_Name = request.getParameter("u_Name");
        if (StringUtils.isNullOrEmpty(u_Name)) {
            return;
        }
        ParticipationService participationService = new ParticipationService();
        participationService.join(l_Theme,u_Name);
        response.sendRedirect("index.jsp");
    }
    public void canceParticipation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String l_ID = request.getParameter("l_ID");
        String username = request.getParameter("username");
        ParticipationService participationService = new ParticipationService();
        participationService.canceParticipation(l_ID);
        List<Participation> participationList = participationService.findparticipationByName(username);
        if (participationList.size()==0) {
            response.sendRedirect("error.jsp");
            return;
        }
        HolidayService holidayService = new HolidayService();
        List<Holiday> list = holidayService.findSomeHoliday(participationList);
        request.setAttribute("list",list);
        request.getRequestDispatcher("myfavorite_list.jsp").forward(request,response);
    }
}

