package com.soft1851.springboot.jpa.service;

import com.soft1851.springboot.jpa.dto.UserDetailParam;
import com.soft1851.springboot.jpa.model.cascade.UserDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author ZENG
 */
public interface UserDetailService {
    /**
     * 条件查询
     * @param detailParam
     * @param pageable
     * @return
     */
    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);
}
