package com.hurley.wanandroid.module.wechat;


import com.hurley.wanandroid.base.BaseContract;
import com.hurley.wanandroid.bean.WxAccountBean;

import java.util.List;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/3/9 6:45 PM
 *      github  : https://github.com/HurleyJames
 *      desc    : 公众号 Contract类
 * </pre>
 */
public interface WechatContract {

    interface View extends BaseContract.BaseView {

        void setWxAccounts(List<WxAccountBean> wxAccounts);
    }

    interface Presenter extends BaseContract.BasePresenter<WechatContract.View> {

        void loadWxAccounts();

        void refresh();
    }
}
