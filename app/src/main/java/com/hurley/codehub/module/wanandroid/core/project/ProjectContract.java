package com.hurley.codehub.module.wanandroid.core.project;


import com.hurley.codehub.base.BaseContract;
import com.hurley.codehub.bean.wanandroid.ProjectBean;

import java.util.List;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/3/14 3:29 PM
 *      github  : https://github.com/HurleyJames
 *      desc    : 项目 Contract类
 * </pre>
 */
public interface ProjectContract {

    interface View extends BaseContract.BaseView {

        /**
         * 设置项目
         *
         * @param projects
         */
        void setProjects(List<ProjectBean> projects);
    }

    interface Presenter extends BaseContract.BasePresenter<ProjectContract.View> {

        /**
         * 加载项目
         */
        void loadProjects();

        /**
         * 刷新
         */
        void refresh();
    }
}
