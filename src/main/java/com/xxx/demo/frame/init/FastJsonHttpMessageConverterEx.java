package com.xxx.demo.frame.init;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * @author Amy
 */
public class FastJsonHttpMessageConverterEx extends FastJsonHttpMessageConverter {
    public FastJsonHttpMessageConverterEx() {
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return super.supports(clazz);
    }
}
