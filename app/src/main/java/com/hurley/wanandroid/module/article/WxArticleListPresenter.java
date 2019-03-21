package com.hurley.wanandroid.module.article;

import android.annotation.SuppressLint;

import com.blankj.utilcode.util.LogUtils;
import com.hurley.wanandroid.api.ApiService;
import com.hurley.wanandroid.app.LoadType;
import com.hurley.wanandroid.base.BaseBean;
import com.hurley.wanandroid.base.BasePresenter;
import com.hurley.wanandroid.bean.ArticleBean;
import com.hurley.wanandroid.bean.PageBean;
import com.hurley.wanandroid.net.RetrofitManager;
import com.hurley.wanandroid.net.callback.RxSchedulers;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/3/20 7:22 PM
 *      github  : https://github.com/HurleyJames
 *      desc    : 微信公众号文章列表 Presenter类
 * </pre>
 */
public class WxArticleListPresenter extends BasePresenter<WxArticleListContract.View> implements WxArticleListContract.Presenter {

    /**
     * 是否刷新
     */
    private boolean isRefresh = true;
    /**
     * 页数
     */
    private int mPage = 0;
    /**
     * 公众号文章id
     */
    private int mId;

    @Inject
    public WxArticleListPresenter() {
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadWxArticles(int id) {
        this.mId = id;
        RetrofitManager.create(ApiService.class)
                .getWxAccountsHistory(mId, mPage)
                .compose(RxSchedulers.applySchedulers())
                .compose(mView.bindToLife())
                .subscribe(new Consumer<BaseBean<ArticleBean>>() {
                    @Override
                    public void accept(BaseBean<ArticleBean> response) throws Exception {
                        if (isRefresh) {
                            mView.setWxArticles(response.getData(), 0);
                        } else {
                            mView.setWxArticles(response.getData(), 1);
                        }
                    }
                });
    }

    @Override
    public void refresh() {
        mPage = 0;
        isRefresh = true;
        loadWxArticles(mId);
    }

    @Override
    public void loadMore() {
        mPage ++;
        isRefresh = false;
        loadWxArticles(mId);
    }

    @Override
    public void collectWxArticle(int position, ArticleBean.DatasBean articleBean) {

    }
}
