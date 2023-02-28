package niannian.mysystem.service;

import niannian.mysystem.pojo.Vo.Files;

/**
 * @author niannianda
 */
public interface FilesService {
    /**
     * 获取当前路径下的文件和目录信息
     * @param path 路径
     * @return
     */
    Files getFiles(String path);
}
