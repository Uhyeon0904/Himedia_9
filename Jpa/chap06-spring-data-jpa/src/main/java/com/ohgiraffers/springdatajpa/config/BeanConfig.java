package com.ohgiraffers.springdatajpa.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        /* setter 메소드 미사용 시 ModelMapper가
         * private 필드에 접근할 수 있도록 설정
         * */
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldAccessLevel(
                        Configuration.AccessLevel.PRIVATE
                )
                .setFieldMatchingEnabled(true);
        return modelMapper;
    }
}
