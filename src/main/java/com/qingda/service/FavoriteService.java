package com.qingda.service;

import com.qingda.dao.FavoriteDao;
import com.qingda.domain.Favorite;

import java.util.List;

/**
 * @author
 * @date 2020/5/22 22:10
 */
public class FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDao();

    public List<Favorite> favoriteListByUser(String u_id) {
        return favoriteDao.getList(u_id);
    }

    public int addFavorite(Favorite favorite) {
        return favoriteDao.insert(favorite);
    }

    public int delete(String l_id,String u_id){
        return favoriteDao.delete(l_id,u_id);
    }

    public Favorite getFavorite(String l_id,String u_id) {
        return favoriteDao.select(l_id,u_id);
    }
}
