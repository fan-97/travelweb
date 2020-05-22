package com.qingda.domain;

/**
 * @author
 * @date 2020/5/22 22:01
 */
public class Favorite {
    private String id;
    /**
     * 收藏的用户
     */
    private String u_id;
    /**
     * 收藏的度假主题
     */
    private String l_id;

    public Favorite() {
    }

    public Favorite( String u_id, String l_id) {
        this.u_id = u_id;
        this.l_id = l_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getL_id() {
        return l_id;
    }

    public void setL_id(String l_id) {
        this.l_id = l_id;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id='" + id + '\'' +
                ", u_id='" + u_id + '\'' +
                ", l_id='" + l_id + '\'' +
                '}';
    }
}
