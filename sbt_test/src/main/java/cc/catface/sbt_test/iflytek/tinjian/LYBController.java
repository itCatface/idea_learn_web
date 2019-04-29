package cc.catface.sbt_test.iflytek.tinjian;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@RestController
public class LYBController {

    @RequestMapping(value = "/AccountService/v1/sms/login/send", method = RequestMethod.POST)
    public void send(HttpServletRequest request) throws IOException {
        /* 1. 获取所有参数 */
        Map<String, String[]> parameterMap = request.getParameterMap();

        System.out.println("--------------------------------参数数量--------------------------------" + parameterMap.size());

        if (null != parameterMap)
            for (String key : parameterMap.keySet()) {
                System.out.println("客户端参数：" + key + "-->" + parameterMap.get(key)[0]);
            }


//        System.out.println(request.getHeader("sdaf"));

        Enumeration<String> headerNames = request.getHeaderNames();
        for (Enumeration e = headerNames; e.hasMoreElements(); ) {
            String thisName = e.nextElement().toString();
            String thisValue = request.getHeader(thisName);
            System.out.println(thisName + "--------------=-=-" + thisValue + " || header参数总数量：");
        }
    }

}
