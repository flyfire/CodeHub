package com.hurley.codehub.bean.wanandroid;

import java.util.List;

/**
 * <pre>
 *      @author hurley
 *      date   : 2018/11/19 下午9:03
 *      github : https://github.com/HurleyJames
 *      desc   : 用户实体类
 * </pre>
 */
public class UserBean {
    private int id;
    private String username;
    private String password;
    private String icon;
    private int type;
    private List<Integer> collectIds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Integer> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(List<Integer> collectIds) {
        this.collectIds = collectIds;
    }
}
