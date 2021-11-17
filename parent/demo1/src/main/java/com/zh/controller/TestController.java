package com.zh.controller;

import com.alibaba.excel.EasyExcel;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.zh.bean.DemoData;
import com.zh.bean.Users;
import com.zh.listener.DemoDataListener;
import com.zh.service.UserService;
import com.zh.zz.GetPropertiesService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class TestController {

    @Autowired
    private UserService userService;
    @Autowired
    GetPropertiesService service;
    @Value("${fdfs.ret-post}")
    String uploadUrl;

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    @GetMapping("/test/{id}")
    public Users getUser(@PathVariable("id") Integer id){
        Users user=userService.getUser(id);
        return user;
    }
    @GetMapping("/user/{id}")
    public String getUser1(@PathVariable("id") Integer id){

        return service.myAuto();
    }

    @PostMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        // 要上传的文件
        //File file = new File("C:\\Users\\张杰\\Desktop\\屏幕截图 2021-11-17 091457.png");
        // 上传并保存图片，参数：1-上传的文件流 2-文件的大小 3-文件的后缀 4-可以不管他
        StorePath storePath = this.storageClient.uploadFile(
                file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        // 带分组的路径
        //System.out.println(storePath.getFullPath());
        // 不带分组的路径
        //System.out.println(storePath.getPath());

        return "http://"+uploadUrl+"/"+storePath.getFullPath();
    }






    /**
     * 文件上传
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link UploadData}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UploadDataListener}
     * <p>
     * 3. 直接读即可
     */
    //@PostMapping("upload")
    //@ResponseBody
   /* public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), DemoData.class, new DemoDataListener()).sheet().doRead();
        return "success";
    }*/
}
