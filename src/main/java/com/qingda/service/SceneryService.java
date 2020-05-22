package com.qingda.service;

import com.qingda.dao.SceneryDao;
import com.qingda.domain.PageBean;
import com.qingda.domain.Scenery;
import com.qingda.utils.PageUtils;

import java.util.List;

public class SceneryService {
    public PageBean<Scenery> findAllscenery(int pageNumber, int pageSize) {
        //1.调用dao查询总数量
        SceneryDao dao = new SceneryDao();
        int totalCount = dao.findTotalCount();
        //2.创建PageBean对象
        PageBean<Scenery> pb = new PageBean(pageNumber,pageSize,totalCount);
        //3.调用dao查询当前页面的数据信息
        //a.调用pb中的方法获取起始索引
        int startIndex = pb.getStartIndex();
        //b.调用dao查询数据信息
        List<Scenery> list = dao.findAllNewsPage(startIndex,pageSize);
        //c.将查询结果封装到pb中
        pb.setData(list);
        //d.计算前五后四 调用工具类计算
        int[] ints = PageUtils.pagination(pageNumber, pb.getTotalPage());
        pb.setStart(ints[0]);
        pb.setEnd(ints[1]);
        //4.将pb返回给web层
        return pb;
    }

    public Scenery findSceneryById(String c_id) {
        SceneryDao dao = new SceneryDao();
        // 调用dao查详情
        return dao.findSceneryById(c_id);
    }

    public PageBean<Scenery> findsceneryByName(int pageNumber, int pageSize, String rname) {
        //1.调用dao查询总数量
        SceneryDao dao = new SceneryDao();
        int totalCount = dao.findTotalCountByName(rname);
        //2.创建PageBean对象
        PageBean<Scenery> pb = new PageBean(pageNumber,pageSize,totalCount);
        //3.调用dao查询当前页面的数据信息
        //a.调用pb中的方法获取起始索引
        int startIndex = pb.getStartIndex();
        //b.调用dao查询数据信息
        List<Scenery> list = dao.findByNamePage(startIndex,pageSize,rname);
        //c.将查询结果封装到pb中
        pb.setData(list);
        //d.计算前五后四 调用工具类计算
        int[] ints = PageUtils.pagination(pageNumber, pb.getTotalPage());
        pb.setStart(ints[0]);
        pb.setEnd(ints[1]);
        //4.将pb返回给web层
        return pb;
    }
}
