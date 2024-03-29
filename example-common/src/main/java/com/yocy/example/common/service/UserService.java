package com.yocy.example.common.service;

import com.yocy.example.common.model.User;

/**
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public interface UserService {

    /**
     * 获取用户
     * @param user
     * @return
     */
    User getUser(User user);
}
