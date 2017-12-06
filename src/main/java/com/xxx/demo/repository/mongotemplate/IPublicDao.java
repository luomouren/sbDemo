package com.xxx.demo.repository.mongotemplate;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * @description:操作MongoDB文档复杂的功能，对mongoTemplate实现
 * @author:@luomouren.
 * @Date:2017-12-03 18:33
 */
public interface IPublicDao<T> {
    /**
     * 更新MongoDB文档
     * @param query 查询条件
     * @param update 更新语句
     * @param T class类
     */
    void update(Query query, Update update, Class T);
}
