package cc.catface.sbt_test.catface;

import cc.catface.sbt_test.util.Const;
import cc.catface.sbt_test.util.ImageUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@RestController
// produces-->避免输出中文乱码
@RequestMapping(value = "/test", produces = "application/json; charset=utf-8")
public class CatfaceController {


    static {
        File fileSave = new File(Const.CATFACE_path_file_save);
        File fileDownload = new File(Const.CATFACE_path_file_download);
        if (!fileSave.exists()) fileSave.mkdirs();
        if (!fileDownload.exists()) fileDownload.mkdirs();
    }


    /**
     * 供客户端请求测试
     */
    @RequestMapping(value = "/test_get", method = RequestMethod.GET)
    @ResponseBody
    public String testGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行方法：testGet()");
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                System.out.println("客户端cookie: " + cookie.getName());
            }
        }
        response.addCookie(new Cookie("cookie_key", "cookie_value"));
        String header1 = request.getHeader("header1");
        System.out.println("header1: " + header1);
        return getTestJson("测试get-name", "测试get-pass");
    }

    @RequestMapping(value = "/test_get_", method = RequestMethod.GET)
    @ResponseBody
    public String testGet(@RequestParam("name") String name, @RequestParam("pass") String pass) {
        System.out.println("执行方法：testGet_()");
        return getTestJson(name, pass);
    }

    @RequestMapping(value = "/test_post", method = RequestMethod.POST)
    @ResponseBody
    public String testPost() {
        System.out.println("执行方法：testPost()");
        return getTestJson("测试post-name", "测试post-pass");
    }

    @RequestMapping(value = "/test_post_", method = RequestMethod.POST)
    @ResponseBody
    public String testPost(@RequestParam("name") String name, @RequestParam("pass") String pass) {
        System.out.println("执行方法：testPost_()");
        return getTestJson(name, pass);
    }


    @RequestMapping(value = "/test_put", method = RequestMethod.PUT)
    @ResponseBody
    public String testPut() {
        System.out.println("执行方法：testPut()");
        return getTestJson("测试-put-nn", "测试-put-pp");
    }

    @RequestMapping(value = "/test_put_", method = RequestMethod.PUT)
    @ResponseBody
    public String testPut(@RequestParam("name") String name, @RequestParam("pass") String pass) {
        System.out.println("执行方法：testPut_()");
        return getTestJson(name, pass);
    }

    @RequestMapping(value = "/test_delete_/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String testDelete(@PathVariable("id") int id) {
        System.out.println("执行方法：testDelete_(): " + id);
        return getTestJson("测试-delete-nn" + id, "测试-delete-pp" + id);
    }

    @RequestMapping(value = "/test_json_", method = RequestMethod.POST)
    @ResponseBody
    public String testJson(@RequestBody String json) {
        System.out.println("执行方法：testJson(): " + json);
        return getTestJson("测试-json-nn", "测试-json-pp");
    }

    @RequestMapping(value = "/test_upload", method = RequestMethod.POST)
    @ResponseBody
    public String test_upload(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("pass") String pass) throws IOException {
        System.out.println("执行方法：test_upload: " + name + "/" + pass);
        upload(request);
        return getTestJson(name, pass);
    }

    @RequestMapping("/test_download")
    public ResponseEntity<byte[]> test_download(@RequestParam("name") String name, @RequestParam("pass") String pass) throws IOException {
        System.out.println("执行方法：test_download: " + name + "/" + pass);
        return download();
    }

    /**
     *
     */
    @RequestMapping(value = "/register")
    // @ResponseBody-->有输出就加这个注解
    @ResponseBody
    public String register(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();

        if (null == map || map.size() < 1) return JSON.toJSONString("当前未上传任何参数！");
        for (String key : map.keySet()) {
            System.out.println(key + "-->" + map.get(key)[0]);
        }

        return JSON.toJSONString(map);
    }


    @RequestMapping(value = "/postJson", method = RequestMethod.POST)
    @ResponseBody
    public String postJson(@RequestBody Map<String, String> map) {
        if (null == map || map.size() < 1) return "当前未上传任何参数！";

        for (String key : map.keySet()) {
            System.out.println(key + "-->" + map.get(key));
        }

        return JSON.toJSONString(map);
    }


    // method = RequestMethod.POST-->设置后只能接收POST请求
    @RequestMapping(value = "/login"/*, method = RequestMethod.POST*/)
    @ResponseBody
    // @RequestParam-->表示该参数必填
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        String method = request.getMethod();    // ==>method is: POST

        return getTestJson(username, password);
    }


    // ↓↓↓通过流保存上传的文件(耗时较长)↓↓↓
    // 将文件封装成CommonsMultipartFile
    @RequestMapping("/uploadByStream")
    public void uploadByStream(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        OutputStream os = new FileOutputStream(Const.CATFACE_path_file_save + file.getOriginalFilename());

        InputStream is = file.getInputStream();

        int temp;
        while ((temp = is.read()) != -1) {
            os.write(temp);
        }

        os.flush();
        os.close();
        is.close();
    }


    // ↓↓↓通过Java API: file.transferTo()保存上传的单个文件↓↓↓
    @RequestMapping("/uploadByJava")
    public void uploadFileByJava(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        file.transferTo(new File(Const.CATFACE_path_file_save + file.getOriginalFilename()));
    }


    // ↓↓↓通过Spring API保存上传的多个文件↓↓↓
    @RequestMapping("/uploadBySpring")
    public void uploadBySpring(HttpServletRequest request) throws IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            Iterator<String> iterator = multiRequest.getFileNames();

            while (iterator.hasNext()) {
                MultipartFile file = multiRequest.getFile(iterator.next());

                if (null != file) {
                    String desPath = Const.CATFACE_path_file_save + file.getOriginalFilename();
                    file.transferTo(new File(desPath));
                }
            }
        }
    }


    // →→→接收文件map & 请求参数map←←←
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void upload(HttpServletRequest request) throws IOException {
        /* 1. 获取所有参数 */
        Map<String, String[]> parameterMap = request.getParameterMap();

        System.out.println("--------------------------------参数数量--------------------------------" + parameterMap.size());

        if (null != parameterMap)
            for (String key : parameterMap.keySet()) {
                System.out.println(key + "-->" + parameterMap.get(key)[0]);
            }


        /* 2. 获取所有文件 */
        CommonsMultipartResolver multiResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multiResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            MultiValueMap<String, MultipartFile> multiFileMap = multiRequest.getMultiFileMap();

            System.out.println("--------------------------------文件数量--------------------------------" + multiFileMap.size());

            for (String key : multiFileMap.keySet()) {
                System.out.println(key + " : " + multiFileMap.get(key).get(0).getOriginalFilename());
                multiFileMap.get(key).get(0).transferTo(new File(Const.CATFACE_path_file_save + multiFileMap.get(key).get(0).getOriginalFilename()));
            }


            /*Iterator<String> iterator = multiRequest.getFileNames();

            while (iterator.hasNext()) {
                Map<String, MultipartFile> fileMap = multiRequest.getFileMap();

                MultipartFile file = fileMap.get("file");

                System.out.println(file.getOriginalFilename());
            }*/
        }
    }


    // 添加一个网上的小demo，没啥用，随便看看
    @RequestMapping("/uploadFiles")
    public void uploadFiles(HttpServletRequest request) throws IOException {
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                //记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不"",说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        System.out.println(myFileName);
                        //重命名上传后的文件名
                        String fileName = "demoUpload" + file.getOriginalFilename();
                        //定义上传路径
                        String path = Const.CATFACE_path_file_save + fileName;
                        File localFile = new File(path);
                        file.transferTo(localFile);
                    }
                }
                //记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                System.out.println(finaltime - pre);
            }
        }
    }


    /*** 向页面输出验证码png ***/
    @RequestMapping("/verificationCode")
    public void verificationCode(HttpServletResponse response, HttpSession session) throws IOException {
        Object[] objArr = ImageUtil.createImage();
        session.setAttribute("imgCode", objArr[0]);

        BufferedImage img = (BufferedImage) objArr[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(img, "png", os);
    }


    /*** 提供文件供客户端下载 ***/
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download() throws IOException {
        File file = null;

        File dir = new File(Const.CATFACE_path_file_download);
        for (File f : dir.listFiles()) {
            if (f.exists() && f.isFile()) {
                file = f;
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", file.getName());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentLength(file.length());

        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }


    /*** 测试带断点续传的文件服务器(未使用，仅供学习) ***/
    @RequestMapping(value = "/download2", method = RequestMethod.GET)
    public void player2(HttpServletRequest request, HttpServletResponse response) {
        //        String path = "D:\\下载\\360Downloads\\xmind-3.7.7.exe";
        //        String path = "D:\\下载\\360Downloads\\网易云音乐_2.3.0.65128.exe";
        //        String path = "D:\\下载\\360Downloads\\web-ssm.zip";
        String path = "D:\\下载\\360Downloads\\adobe.exe";
        BufferedInputStream bis = null;
        try {
            File file = new File(path);
            if (file.exists()) {
                long p = 0L;
                long toLength = 0L;
                long contentLength = 0L;
                int rangeSwitch = 0; // 0,从头开始的全文下载；1,从某字节开始的下载（bytes=27000-）；2,从某字节开始到某字节结束的下载（bytes=27000-39000）
                long fileLength;
                String rangBytes = "";
                fileLength = file.length();

                // get file content
                InputStream ins = new FileInputStream(file);
                bis = new BufferedInputStream(ins);

                // tell the client to allow accept-ranges
                response.reset();
                response.setHeader("Accept-Ranges", "bytes");

                // client requests a file block download start byte
                String range = request.getHeader("Range");
                if (range != null && range.trim().length() > 0 && !"null".equals(range)) {
                    response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                    rangBytes = range.replaceAll("bytes=", "");
                    if (rangBytes.endsWith("-")) {  // bytes=270000-
                        rangeSwitch = 1;
                        p = Long.parseLong(rangBytes.substring(0, rangBytes.indexOf("-")));
                        contentLength = fileLength - p;  // 客户端请求的是270000之后的字节（包括bytes下标索引为270000的字节）
                    } else { // bytes=270000-320000
                        rangeSwitch = 2;
                        String temp1 = rangBytes.substring(0, rangBytes.indexOf("-"));
                        String temp2 = rangBytes.substring(rangBytes.indexOf("-") + 1, rangBytes.length());
                        p = Long.parseLong(temp1);
                        toLength = Long.parseLong(temp2);
                        contentLength = toLength - p + 1; // 客户端请求的是 270000-320000 之间的字节
                    }
                } else {
                    contentLength = fileLength;
                }

                // 如果设设置了Content-Length，则客户端会自动进行多线程下载。如果不希望支持多线程，则不要设置这个参数。
                // Content-Length: [文件的总大小] - [客户端请求的下载的文件块的开始字节]
                response.setHeader("Content-Length", new Long(contentLength).toString());

                // 断点开始
                // 响应的格式是:
                // Content-Range: bytes [文件块的开始字节]-[文件的总大小 - 1]/[文件的总大小]
                if (rangeSwitch == 1) {
                    String contentRange = new StringBuffer("bytes ").append(new Long(p).toString()).append("-")
                            .append(new Long(fileLength - 1).toString()).append("/")
                            .append(new Long(fileLength).toString()).toString();
                    response.setHeader("Content-Range", contentRange);
                    bis.skip(p);
                } else if (rangeSwitch == 2) {
                    String contentRange = range.replace("=", " ") + "/" + new Long(fileLength).toString();
                    response.setHeader("Content-Range", contentRange);
                    bis.skip(p);
                } else {
                    String contentRange = new StringBuffer("bytes ").append("0-")
                            .append(fileLength - 1).append("/")
                            .append(fileLength).toString();
                    response.setHeader("Content-Range", contentRange);
                }

                String fileName = file.getName();
                response.setContentType("application/octet-stream");
                response.addHeader("Content-Disposition", "attachment;filename=" + fileName);

                OutputStream out = response.getOutputStream();
                int n = 0;
                long readLength = 0;
                int bsize = 1024;
                byte[] bytes = new byte[bsize];
                if (rangeSwitch == 2) {
                    // 针对 bytes=27000-39000 的请求，从27000开始写数据
                    while (readLength <= contentLength - bsize) {
                        System.out.println("readLength <= contentLength - bsize-->" + readLength + "|" + contentLength + "|" + bsize);

                        n = bis.read(bytes);
                        readLength += n;
                        out.write(bytes, 0, n);
                    }
                    if (readLength <= contentLength) {
                        System.out.println("readLength <= contentLength-->" + readLength + "|" + contentLength);
                        n = bis.read(bytes, 0, (int) (contentLength - readLength));
                        out.write(bytes, 0, n);
                    }
                } else {
                    while ((n = bis.read(bytes)) != -1) {
                        System.out.println("n = bis.read(bytes)) != -1-->" + n + "|" + bytes);
                        out.write(bytes, 0, n);
                    }
                }
                out.flush();
                out.close();
                bis.close();
            } else {
                //                if (logger.isDebugEnabled()) {
                //                    logger.debug("Error: file " + path + " not found.");
                //                }
            }
        } catch (IOException ie) {
            // 忽略 ClientAbortException 之类的异常
        } catch (Exception e) {
            //            logger.error(e.getMessage());
        }
    }


    /**
     *
     */
    private String getTestJson(String username, String password) {
        JSONObject json = new JSONObject();

        JSONObject userInfo = new JSONObject();
        userInfo.put("rsp", "0");
        userInfo.put("opId", "20180210");
        userInfo.put("orgId", "4007250");

        JSONObject busiInfo1 = new JSONObject();
        busiInfo1.put("id", "0");
        busiInfo1.put("busiId", "taocan0");
        busiInfo1.put("busiName", "套餐0");
        JSONObject busiInfo2 = new JSONObject();
        busiInfo2.put("id", "1");
        busiInfo2.put("busiId", "taocan1");
        busiInfo2.put("busiName", "套餐1");
        JSONArray busiInfo = new JSONArray();
        busiInfo.add(0, busiInfo1);
        busiInfo.add(1, busiInfo2);

        JSONObject infoList = new JSONObject();
        infoList.put("busiInfo", busiInfo);
        infoList.put("userInfo", userInfo);
        infoList.put("username", username);
        infoList.put("password", password);

        json.put("data", infoList);
        json.put("code", "0");
        json.put("message", "操作成功");

        return json.toJSONString();
    }
}
