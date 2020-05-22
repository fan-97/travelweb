package com.qingda.service;

import com.qingda.dao.HolidayDao;
import com.qingda.domain.Holiday;
import com.qingda.domain.PageBean;
import com.qingda.domain.Participation;
import com.qingda.utils.PageUtils;

import java.util.List;

public class HolidayService {
    public PageBean<Holiday> findAllHoliday(int pageNumber, int pageSize) {
        //1.调用dao查询总数量
        HolidayDao dao = new HolidayDao();
        int totalCount = dao.findTotalCount();
        //2.创建PageBean对象
        PageBean<Holiday> pb = new PageBean(pageNumber,pageSize,totalCount);
        //3.调用dao查询当前页面的数据信息
        //a.调用pb中的方法获取起始索引
        int startIndex = pb.getStartIndex();
        //b.调用dao查询数据信息
        List<Holiday> list = dao.findAllHolidayPage(startIndex,pageSize);
        //c.将查询结果封装到pb中
        pb.setData(list);
        //d.计算前五后四 调用工具类计算
        int[] ints = PageUtils.pagination(pageNumber, pb.getTotalPage());
        pb.setStart(ints[0]);
        pb.setEnd(ints[1]);
        //4.将pb返回给web层
        return pb;
    }

    public Holiday findDetailholiday(String l_id) {
        HolidayDao holidayDao = new HolidayDao();
        return holidayDao.findDetailholiday(l_id);
    }

    public List<Holiday> findSomeHoliday(List<Participation> participationList) {
        HolidayDao holidayDao = new HolidayDao();
        return holidayDao.findSomeHoliday(participationList);
    }
}
