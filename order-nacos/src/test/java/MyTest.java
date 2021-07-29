import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.liqiuyue.order.OrderApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
@Slf4j
public class MyTest {

    @Test
    public void getSpringVersion() {
        String version = SpringVersion.getVersion();
        String version1 = SpringBootVersion.getVersion();
        System.out.println(version);
        System.out.println(version1);
    }

    @Test
    public void test() {
        String applyDmpDetailConfig = "{\"applyAmount\":\"$.categories[?(@.code=='field')].vars.[mount].value\"}";
        JSONObject config = JSON.parseObject(applyDmpDetailConfig);
        JSONObject resultJsonObject = (JSONObject) parseJson(getString(), config);
        System.out.println(resultJsonObject);
    }
    public Object parseJson(String jsonDataString, Object json) {
        // 如果是字符串,也就是配置里的"$.xxxx.xxx",从数据中取出对应数据
        if (json instanceof String) {
            Object read = null;
            try {
                read = JSONPath.read(jsonDataString, (String) json);
            } catch (Exception e) {
                log.error("Json解析错误" + jsonDataString + "--->" + json);
            }
            return read;
        }
        // 如果是JSON数组,遍历每一项,结构不变返回
        if (json instanceof JSONArray) {
            JSONArray array = (JSONArray) json;
            JSONArray arrayAns = new JSONArray();
            for (Object o : array) {
                arrayAns.add(parseJson(jsonDataString, o));
            }
            return arrayAns;
        }
        // 如果是Json对象，遍历每一对键值，结构不变返回
        if (json instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) json;
            JSONObject jsonObjectAns = new JSONObject();
            for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                Object value = parseJson(jsonDataString, entry.getValue());
                if (entry.getValue() instanceof String && value == null) {
                    value = "";
                }
                jsonObjectAns.put(entry.getKey(), value);
            }
            return jsonObjectAns;
        }
        return "";
    }

    private static String getString() {
        return "{\n" +
                "    \"result\":{\n" +
                "        \"dmpResult\":{\n" +
                "            \n" +
                "        \"riskLevel\": \"pass\",\n" +
                "        \"businessId\": \"1412352543899533313\",\n" +
                "        \"categories\": [{\n" +
                "                \"code\": \"feature\",\n" +
                "                \"name\": \"数据源数据\",\n" +
                "                \"vars\": {\n" +
                "                        \"TY_FraudScore_I\": {\n" +
                "                                \"code\": \"TY_FraudScore_I\",\n" +
                "                                \"name\": \"天御_反欺诈评分\",\n" +
                "                                \"value\": 88,\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        }\n" +
                "                }\n" +
                "        }, {\n" +
                "                \"code\": \"field\",\n" +
                "                \"name\": \"变量\",\n" +
                "                \"vars\": {\n" +
                "                        \"back_var.core\": {\n" +
                "                                \"code\": \"back_var.core\",\n" +
                "                                \"name\": \"返回变量.风险评分\",\n" +
                "                                \"value\": 100,\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        },\n" +
                "                        \"mount\": {\n" +
                "                                \"code\": \"back_var.mount\",\n" +
                "                                \"name\": \"返回变量.金额\",\n" +
                "                                \"value\": 500,\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        },\n" +
                "                        \"system_var.hit\": {\n" +
                "                                \"code\": \"system_var.hit\",\n" +
                "                                \"name\": \"系统变量.规则命中\",\n" +
                "                                \"value\": 0,\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        },\n" +
                "                        \"back_var.customerType\": {\n" +
                "                                \"code\": \"back_var.customerType\",\n" +
                "                                \"name\": \"返回变量.客户类型\",\n" +
                "                                \"value\": \"VIP客群\",\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        },\n" +
                "                        \"system_var.Phone3sNum\": {\n" +
                "                                \"code\": \"system_var.Phone3sNum\",\n" +
                "                                \"name\": \"系统变量.手机号前3位号码\",\n" +
                "                                \"value\": \"136\",\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        }\n" +
                "                }\n" +
                "        }, {\n" +
                "                \"code\": \"ruleResult\",\n" +
                "                \"name\": \"规则结果\",\n" +
                "                \"vars\": {\n" +
                "                        \"testcode1.job\": {\n" +
                "                                \"code\": \"testcode1.job\",\n" +
                "                                \"name\": \"测试组件1.职业不满足要求\",\n" +
                "                                \"value\": 0,\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        },\n" +
                "                        \"testcode.tianyu\": {\n" +
                "                                \"code\": \"testcode.tianyu\",\n" +
                "                                \"name\": \"测试组件.天御分值过大\",\n" +
                "                                \"value\": 0,\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        },\n" +
                "                        \"testcode1.mobile\": {\n" +
                "                                \"code\": \"testcode1.mobile\",\n" +
                "                                \"name\": \"测试组件1.电话号码不满足要求\",\n" +
                "                                \"value\": 0,\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        },\n" +
                "                        \"testcode2.cardNo\": {\n" +
                "                                \"code\": \"testcode2.cardNo\",\n" +
                "                                \"name\": \"测试组件2.身份证号码不满足\",\n" +
                "                                \"value\": 0,\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        },\n" +
                "                        \"testcode1.ducation\": {\n" +
                "                                \"code\": \"testcode1.ducation\",\n" +
                "                                \"name\": \"测试组件1.学历不满足要求\",\n" +
                "                                \"value\": 0,\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        },\n" +
                "                        \"testcode1.marriage\": {\n" +
                "                                \"code\": \"testcode1.marriage\",\n" +
                "                                \"name\": \"测试组件1.婚姻不满足条件\",\n" +
                "                                \"value\": 0,\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        },\n" +
                "                        \"testcode1.Phone3sNum\": {\n" +
                "                                \"code\": \"testcode1.Phone3sNum\",\n" +
                "                                \"name\": \"测试组件1.手机号前3位号码不满足\",\n" +
                "                                \"value\": 1,\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        }\n" +
                "                }\n" +
                "        }, {\n" +
                "                \"code\": \"outerField\",\n" +
                "                \"name\": \"数据源数据\",\n" +
                "                \"vars\": {\n" +
                "                        \"certNo\": {\n" +
                "                                \"code\": \"certNo\",\n" +
                "                                \"name\": \"身份证\",\n" +
                "                                \"value\": \"530822198908271559\",\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        },\n" +
                "                        \"mobile\": {\n" +
                "                                \"code\": \"mobile\",\n" +
                "                                \"name\": \"手机号\",\n" +
                "                                \"value\": \"13678170160\",\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        },\n" +
                "                        \"marriage\": {\n" +
                "                                \"code\": \"marriage\",\n" +
                "                                \"name\": \"婚姻状况\",\n" +
                "                                \"value\": \"已婚\",\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        },\n" +
                "                        \"education\": {\n" +
                "                                \"code\": \"education\",\n" +
                "                                \"name\": \"学历\",\n" +
                "                                \"value\": \"高中\",\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        },\n" +
                "                        \"jobOccupation\": {\n" +
                "                                \"code\": \"jobOccupation\",\n" +
                "                                \"name\": \"职业\",\n" +
                "                                \"value\": \"军人\",\n" +
                "                                \"outputKey\": \"\"\n" +
                "                        }\n" +
                "                }\n" +
                "        }]\n" +
                "\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "\n";
    }
}
