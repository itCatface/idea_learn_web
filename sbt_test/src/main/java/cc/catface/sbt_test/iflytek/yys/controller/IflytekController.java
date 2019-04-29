package cc.catface.sbt_test.iflytek.yys.controller;

import cc.catface.sbt_test.util.IO.FileT;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */

@Controller
@RequestMapping(produces = "application/json; charset=utf-8")
public class IflytekController {

    @RequestMapping("/app/device/getActivationState")
    @ResponseBody
    public String getActivationState() {
        return "";
    }

    @RequestMapping("/app/app/getVersion")
    @ResponseBody
    public String getVersion() {
        Map<String, String> map = new HashMap<>();
        map.put("version", "10000");
        map.put("url", "http://10.73.150.101:8080/iflytek/app/app/apkPath");
        map.put("md5", "b0308d7a9ab51b68543c232cdedf04a4");
        map.put("status", "0");

        return JSON.toJSONString(map);
    }


    @RequestMapping("/app/app/apkPath")
    public ResponseEntity<byte[]> downloadFile() throws IOException {
        System.out.println("接口开始执行-->downloadFile");

        File file = new File("C:\\Users\\Administrator\\Desktop\\AAA综合\\app-debug.apk");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "app-debug.apk");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentLength(file.length());

        System.out.println(file.length() + " is length,..");

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }


    /* →→→接收文件map & 请求参数map←←← */
    @RequestMapping(value = "/log-web/upload/imgUpload", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String imgUpload(HttpServletRequest request) throws IOException {
        System.out.println("接口开始执行-->imgUpload");

        /* 1. 获取所有参数 */
        Map<String, String[]> parameterMap = request.getParameterMap();


        for (String key : parameterMap.keySet()) {
            System.out.println(key + ":" + parameterMap.get(key)[0]);
        }


        /* 2. 获取所有文件 */
        CommonsMultipartResolver multiResolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        if (multiResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            MultiValueMap<String, MultipartFile> multiFileMap = multiRequest.getMultiFileMap();
            System.out.println("文件数量: " + multiFileMap.size()); // 入参数量
            for (String key : multiFileMap.keySet()) {
                System.out.println(key + " : " + multiFileMap.get(key).get(0).getOriginalFilename());
                multiFileMap.get(key).get(0).transferTo(new File("d:/a/a/" + multiFileMap.get(key).get(0).getOriginalFilename()));
            }
        }

        return "uploadFileBySpringAndFileName suc...";
    }


    @RequestMapping(value = "/app/user/newLogin")
    @ResponseBody
    public String newLogin() {
        return FileT.read("D:\\catface\\java\\catface-ssm\\src\\main\\java\\cc\\catface\\module\\iflytek\\results\\newLogin.txt");
    }

    @RequestMapping(value = "/app/user/changeNewLogin")
    @ResponseBody
    public String changeNewLogin() {
        return FileT.read("D:\\catface\\java\\catface-ssm\\src\\main\\java\\cc\\catface\\module\\iflytek\\results\\changeNewLogin.txt");
    }

    @RequestMapping(value = "/SpringBootAPI/RechargeActivity/findLevel")
    @ResponseBody
    public String findLevel() {
        return FileT.read("D:\\catface\\java\\catface-ssm\\src\\main\\java\\cc\\catface\\module\\iflytek\\results\\findLevel.txt");
    }

    @RequestMapping(value = "/zjyd/qd/getPhonePrice")
    @ResponseBody
    public String getPhonePrice() {
        return FileT.read("D:\\catface\\java\\catface-ssm\\src\\main\\java\\cc\\catface\\module\\iflytek\\results\\getPhonePrice.txt");
    }


    @RequestMapping(value = "/zjyd/qd/checkContract")
    @ResponseBody
    public String checkContract() {
        return FileT.read("D:\\catface\\java\\catface-ssm\\src\\main\\java\\cc\\catface\\module\\iflytek\\results\\checkContract.txt");
    }

    @RequestMapping(value = "/zjyd/qd/exec_gsm_change_001")
    @ResponseBody
    public String exec_gsm_change_001() {
        return FileT.read("D:\\catface\\java\\catface-ssm\\src\\main\\java\\cc\\catface\\module\\iflytek\\results\\exec_gsm_change_001.txt");
    }
}
