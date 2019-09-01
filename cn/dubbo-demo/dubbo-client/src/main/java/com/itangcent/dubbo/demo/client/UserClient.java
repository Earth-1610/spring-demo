package com.itangcent.dubbo.demo.client;

import com.itangcent.common.model.UserInfo;

import java.util.List;

/**
 * 用户相关Client
 *
 * @module user
 */
public interface UserClient {

    /**
     * 打个招呼
     */
    public String greeting();


    /**
     * 更新用户名
     *
     * @param id      用户id
     * @param newName 新的用户名
     * @param slogon  个人签名
     * @deprecated 改用{@link #update(UserInfo)}
     */
    public UserInfo set(long id, String newName,
                        String slogon,
                        long times);

    /**
     * 获取用户信息
     *
     * @param id 用户id
     */
    @Deprecated
    public UserInfo get(Long id);

    /**
     * 增加新用户
     */
    public UserInfo add(UserInfo userInfo);

    /**
     * 更新用户信息
     */
    public void update(UserInfo userInfo);

    /**
     * 获取用户列表
     */
    public List<UserInfo> list();

    /**
     * 删除用户信息
     *
     * @param id 用户id
     */
    public UserInfo delete(Long id);

}
