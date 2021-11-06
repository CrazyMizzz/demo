package com.example.demo.dao.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.demo.domain.BaseDomain;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BaseDomainObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.getOriginalObject() instanceof BaseDomain) {
            this.strictInsertFill(metaObject, "createDate", Date.class, new Date());
            this.strictInsertFill(metaObject, "updateDate", Date.class, new Date());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateDate", Date.class, new Date());
    }
}