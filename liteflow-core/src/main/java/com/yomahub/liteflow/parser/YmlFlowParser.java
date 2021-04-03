package com.yomahub.liteflow.parser;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

/**
 * Yml格式解析器，转换为json格式进行解析
 * @Author: guodongqing
 * @Date: 2021/3/29 2:29 下午
 */
public abstract class YmlFlowParser extends JsonFlowParser{

    private final Logger LOG = LoggerFactory.getLogger(YmlFlowParser.class);

    @Override
    public void parseMain(String rulePath) throws Exception {
        String ruleContent = FileUtil.readUtf8String(rulePath);
        JSONObject ruleObject = convertToJson(ruleContent);
        parse(ruleObject.toJSONString());
    }

    private JSONObject convertToJson(String yamlString) {
        Yaml yaml= new Yaml();
        Map<String, Object> map = yaml.load(yamlString);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }
}
