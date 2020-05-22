package com.qingda.web.servlet;


import com.mysql.jdbc.StringUtils;
import com.qingda.domain.Holiday;
import com.qingda.domain.Order;
import com.qingda.domain.Participation;
import com.qingda.domain.User;
import com.qingda.service.HolidayService;
import com.qingda.service.ParticipationService;
import com.qingda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ParticipationServlet", urlPatterns = "/participation")
public class ParticipationServlet extends BaseServlet {

    private HolidayService holidayService = new HolidayService();
    private ParticipationService participationService = new ParticipationService();
    private UserService userService = new UserService();

    public void findparticipationByName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        List<Participation> participationList = participationService.findparticipationByName(username);
        request.setAttribute("list", participationList);
        request.getRequestDispatcher("myfavorite_list.jsp").forward(request, response);
    }

    public void participationDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String p_id = request.getParameter("p_id");
        Participation participation = participationService.findById(p_id);
        Holiday holiday = holidayService.findDetailholiday(participation.getP_hoildayid());

        //获取参团的信息
        Order order = new Order(participation.getFlag(),holiday.getL_ID(), holiday.getL_Theme(), holiday.getL_Destination(),participation.getPrice() , holiday.getL_Data(), holiday.getL_Traffic(), holiday.getL_TravelDays(), holiday.getL_Participant(), holiday.getL_Explain(), participation.getP_id(), participation.getP_nameid());
        request.getSession().setAttribute("order", order);
        response.sendRedirect("order.jsp");
    }


    public void join(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String l_Theme = request.getParameter("l_Theme");
        String u_Name = request.getParameter("u_Name");
        if (StringUtils.isNullOrEmpty(u_Name)) {
            request.getSession().setAttribute("msg", "请登录后再操作！");
            response.sendRedirect("error.jsp");
            return;
        }
        User user = userService.getUserByName(u_Name);
        if (user == null) {
            request.getSession().setAttribute("msg", "请登录后再操作！");
            response.sendRedirect("error.jsp");
            return;
        }
        Holiday holiday = holidayService.findDetailholiday(l_Theme);

        Participation participation = participationService.join(new Participation(0,u_Name,l_Theme,switchPrice(user, holiday)));
        //获取参团的信息
        Order order = new Order(participation.getFlag(),holiday.getL_ID(), holiday.getL_Theme(), holiday.getL_Destination(),participation.getPrice() , holiday.getL_Data(), holiday.getL_Traffic(), holiday.getL_TravelDays(), holiday.getL_Participant(), holiday.getL_Explain(), participation.getP_id(), participation.getP_nameid());
        request.getSession().setAttribute("order", order);
        response.sendRedirect("order.jsp");
    }

    public void canceParticipation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String p_ID = request.getParameter("p_ID");
        Participation participation = participationService.findById(p_ID);
        participationService.canceParticipation(p_ID);
        List<Participation> participationList = participationService.findparticipationByName(participation.getP_nameid());
        if (participationList.size() == 0) {
            response.sendRedirect("error.jsp");
            return;
        }
        request.setAttribute("list", participationList);
        request.getRequestDispatcher("myfavorite_list.jsp").forward(request, response);
    }

    /**
     * 支付接口
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public synchronized void pay(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String price = request.getParameter("price");
        String p_id = request.getParameter("p_ID");

        Participation participation = participationService.findById(p_id);
        String userName = participation.getP_nameid();

        User user = userService.getUserByName(userName);
        user.setU_price(user.getU_price().subtract(BigDecimal.valueOf(Double.valueOf(price))));
        if(user.getU_price().compareTo(BigDecimal.ZERO)<0) {
            request.getSession().setAttribute("msg","账户余额不足，请充值！");
            response.sendRedirect("error.jsp");
            return;
        }

        // 从用户的账户里面扣除订单的金额
        userService.addprice(user.getU_ID(),user.getU_price());
        // 更新订单的支付状态
        participation.setFlag(1);
        participationService.update(participation);

        request.getSession().setAttribute("msg",String.format("支付成功！账户余额:{%s}",user.getU_price()));
        request.getRequestDispatcher("success.jsp").forward(request,response);

    }

    /**
     * 通过年龄来判断参团时候的价格
     * - 1. age < 12 : 儿童票
     * - 2. age <= 24 : 学生票
     * - 3. age > 24 : 常规票
     */
    private String switchPrice(User user, Holiday holiday) {
        LocalDate userBirth = LocalDate.parse(user.getU_Birth());
        LocalDate now = LocalDate.now();
        int age = userBirth.getYear() - now.getYear();
        if (userBirth.getMonthValue() > now.getMonthValue()) {
            age -= 1;
        } else if (userBirth.getMonthValue() == now.getMonthValue()) {
            if (userBirth.getDayOfMonth() > now.getDayOfMonth()) {
                age -= 1;
            }
        }
        return switchPrice(age, holiday);
    }

    private String switchPrice(int age, Holiday holiday) {
        if (age <= 12) {
            return holiday.getL_ChildPrice();
        } else if (age <= 24) {
            return holiday.getL_StudentPrice();
        } else {
            return holiday.getL_RetailPrice();
        }
    }

}

