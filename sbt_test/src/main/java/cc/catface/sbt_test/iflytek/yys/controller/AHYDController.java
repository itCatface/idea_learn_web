package cc.catface.sbt_test.iflytek.yys.controller;

import cc.catface.sbt_test.iflytek.yys.engine.Common;
import cc.catface.sbt_test.util.IO.FileT;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Controller
@RequestMapping(produces = "application/json; charset=utf-8")
public class AHYDController {

    @RequestMapping("/api/login/serviceCode")
    @ResponseBody
    public String serviceCode() {
        return FileT.read(Common.rootPathAH + "serviceCode.txt");
    }

    @RequestMapping("/api/login/getSms")
    @ResponseBody
    public String getSms() {
        return FileT.read(Common.rootPathAH + "getSms.txt");
    }


    @RequestMapping("/api/login/checkSms")
    @ResponseBody
    public String checkSms() {
        return FileT.read(Common.rootPathAH + "checkSms.txt");
    }


    /** 补换卡模块 */
    @RequestMapping("/api/close/checkById")
    @ResponseBody
    public String checkById() {
        Common.sleep((new Random().nextInt(5) + 2) * 1_000);
        return FileT.read(Common.rootPathAH + "checkById.txt");
    }

    @RequestMapping("/api/transCard/checkPhoneNo")
    @ResponseBody
    public String checkPhoneNo() {
        Common.sleep((new Random().nextInt(5) + 2) * 1_000);
        return FileT.read(Common.rootPathAH + "checkPhoneNo.txt");
    }

    @RequestMapping("/api/transCard/writeSimCard")
    @ResponseBody
    public String writeSimCard() {
        Common.sleep((new Random().nextInt(3) + 2) * 1_000);
        return FileT.read(Common.rootPathAH + "writeSimCard.txt");
    }

    @RequestMapping("/api/transCard/confirmTransCard")
    @ResponseBody
    public String confirmTransCard() {
        Common.sleep((new Random().nextInt(5) + 2) * 1_000);
        return FileT.read(Common.rootPathAH + "confirmTransCard.txt");
    }

    @RequestMapping("/api/signature/getSignatureVar")
    @ResponseBody
    public String getSignatureVar() {
        Common.sleep((new Random().nextInt(5) + 2) * 1_000);
        return FileT.read(Common.rootPathAH + "getSignatureVar.txt");
    }

    @RequestMapping("/api/realProtocol/realPicUpload")
    @ResponseBody
    public String realPicUpload() {
        Common.sleep((new Random().nextInt(5) + 2) * 1_000);
        return FileT.read(Common.rootPathAH + "realPicUpload.txt");
    }
}
