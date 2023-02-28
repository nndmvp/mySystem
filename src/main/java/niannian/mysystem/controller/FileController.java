package niannian.mysystem.controller;/**
 * @author niannianda
 */

import niannian.mysystem.dao.FilesDao;
import niannian.mysystem.pojo.Vo.Files;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @title: FileController
 * @Author Tan
 * @Date: 2023/2/24 21:08
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class FileController {

    /**
     * 文件系统主界面
     * @return 返回文件和目录的信息总和
     */
    @RequestMapping("/files")
    @ResponseBody
    public Files getFiles(){
        Files files = new Files();
        return files;
    }


}
