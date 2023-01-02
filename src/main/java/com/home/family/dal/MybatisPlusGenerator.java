package com.home.family.dal;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @Project : home-family
 * @Package : com.home.family.dal
 * @Author : richur
 * @Date : 2023/1/1 10:36 下午
 */

public class MybatisPlusGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/home_family?serverTimezone=Asia/Shanghai", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("home-family-generator")
                            .outputDir("src/main/java/");
                })
                .packageConfig(builder -> {
                    builder.parent("com.home.family")
                            .moduleName("dal")
                            .service("dao")
                            .serviceImpl("dao.impl")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "src/main/resources/mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("family_information","family_member_information","family_member_score_detail")
                            .addTablePrefix("t_", "c_")
                            .serviceBuilder()
                            .formatServiceFileName("I%sDAO")
                            .formatServiceImplFileName("%sDAO");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .templateConfig(builder -> builder.controller(""))
                .execute();
    }
}
