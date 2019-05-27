package com.vuelearn.pro.util;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        // 设置生成文件的输出目录，默认为D盘根目录
        gc.setOutputDir(projectPath + "/src/main/java");
        //是否覆盖已有文件
        gc.setFileOverride(true);
        // 设置自动生成的代码的注解中的作者名
        //是否增加二级缓存
        gc.setAuthor("Gronbu1");
        // 是否打开输出目录
        gc.setOpen(false);
        // 设置实体命名方式
        gc.setEntityName("%s");
        // 设置mapper命名方式
        gc.setMapperName("%sMapper");
        // 设置XML的命名方式
        gc.setXmlName("%sMapper");
        // 设置service的命名方式
        gc.setServiceName("%sService");
        // 设置serviceImpl的命名方法
        gc.setServiceImplName("%sServiceImpl");
        // 设置controllerName的命名方式
        gc.setControllerName("%sController");
        // 设置指定生成的主键的ID类型
        gc.setIdType(IdType.AUTO);
        // 设置mapper.xml生成resultMap
        gc.setBaseResultMap(true);
        // 设置ColumList
        gc.setBaseColumnList(true);
        // 设置mapper.xml生成ColumnList
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(
                "jdbc:mysql://localhost:3306/vuelearn?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("ccc");
        dsc.setPassword("12312");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 设置父包模块名，应该是maven分模块开发,如：订单模块，order
        pc.setModuleName("pro");
        // 设置父包名
        pc.setParent("com.vuelearn");
        // 设置实体包名
        pc.setEntity("entity");
        // 设置mapper
        pc.setMapper("mapper");
        // 设置Service包名
        pc.setService("service");
        // 设置ServiceImpl包名
        pc.setServiceImpl("service.Impl");
        // 设置controller
        pc.setController("controller");

        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        // String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        // mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();
        // templateConfig.setXml();
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 数据库表映射到实体的命名策略,这里很奇怪,
        // 只提供了nochange和underline_to_camel，但是其实是有removePrefixAndCamel处理方法的。
        // 比如：现在我有表tb_product生成的是TbProduct，但是我想要的是Product..
        // 在官方的mybatis3.4.0中提供了解决方案，这里好像还是没有0-0.
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 是否生成自定义继承类 ，简单说就是是否给孩子们找个爸爸
        // strategy.setSuperEntityClass("com.ccc.BaseEntity");
        // 是否使用lombok模型实体类@Data之类的
        strategy.setEntityLombokModel(true);
        // 是否打上@restController
        strategy.setRestControllerStyle(true);
        // 是否生成自定义继承类 ，简单说就是是否给孩子们找个爸爸
        // strategy.setSuperControllerClass("com.ccc.BaseController");
        String[] tb = new String[]{"vlearnprod"};
        // 设置需要生成的表名,参数是数组
        strategy.setInclude(tb);
        // 找个有所有孩子公共特性的爸爸，参数是数组
        strategy.setSuperEntityColumns("id");
        // 驼峰转连字符,AttSccSee->att-scc-see,就是requestmapping的value.
        strategy.setControllerMappingHyphenStyle(false);
        // 设置表前缀，这里是配合setNaming来使用的,这里配置好就key解决去前缀转驼峰
        strategy.setTablePrefix("tb" + "_");
        mpg.setStrategy(strategy);
        // mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}