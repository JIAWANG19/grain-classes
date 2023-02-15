package com.atcjw;


//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


import java.util.Collections;

public class CodeGet {
//    public static void main(String[] args) {
//        FastAutoGenerator.create("jdbc:mysql://localhost:3306/glkt_vod", "root", "1234").
//                globalConfig(builder -> {
//                    builder.author("atcjw")
//                            .enableSwagger()
//                            .fileOverride()
//                            .outputDir("D:\\soft\\IdeaProjects\\grain-classes\\service\\service-vod" + "\\src\\main\\java");
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.atcjw")
//                            .moduleName("vod")
//                            .pathInfo(Collections.singletonMap(OutputFile.xml,
//                                    "D:\\soft\\IdeaProjects\\grain-classes\\service\\service-vod" + "\\src\\main\\resources"));
//                })
//                .strategyConfig(builder -> {
//                    builder.addInclude("teacher")
//                            .addTablePrefix();
//                })
//                .templateEngine(new FreemarkerTemplateEngine())
//                .execute();
//    }

//    public static void main(String[] args) {
//
//        // 1、创建代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 2、全局配置
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        //gc.setOutputDir(projectPath + "/src/main/java");
//        gc.setOutputDir("D:\\soft\\IdeaProjects\\grain-classes\\service\\service-vod" + "/src/main/java");
//
//        gc.setServiceName("%sService");    //去掉Service接口的首字母I
//        gc.setAuthor("atcjw");
//        gc.setOpen(false);
//        mpg.setGlobalConfig(gc);
//
//        // 3、数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://localhost:3306/glkt_vod");
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("1234");
//        dsc.setDbType(DbType.MYSQL);
//        mpg.setDataSource(dsc);
//
//        // 4、包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("vod"); //模块名
//        pc.setParent("com.atcjw");
//        pc.setController("controller");
//        pc.setEntity("entity");
//        pc.setService("service");
//        pc.setMapper("mapper");
//        mpg.setPackageInfo(pc);
//
//        // 5、策略配置
//        StrategyConfig strategy = new StrategyConfig();
//
//        strategy.setInclude("teacher");
//
//        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
//
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
//        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作
//
//        strategy.setRestControllerStyle(true); //restful api风格控制器
//        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符
//
//        mpg.setStrategy(strategy);
//
//        // 6、执行
//        mpg.execute();
//    }
}
