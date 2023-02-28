package niannian.mysystem.dao;

import niannian.mysystem.pojo.Vo.Files;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;

/**
 * @author niannianda
 */
public interface FilesDao {

    /**
     * 获取hdfs文件系统
     * @return
     */
    FileSystem getSystem();

    /**
     * 获取当前路径下的文件和目录信息
     * @param path 路径
     * @return
     */
    Files getFiles(String path);

    /**
     * 指定目录下文件或目录是否存在
     * @param name
     * @param path
     * @return
     * @throws IOException
     */
    boolean isExist(String name,String path);

    /**
     * 上传文件
     * @param filePath 所上传的文件的路径位置
     * @param path 上传的位置
     * @return
     */
    boolean upload(String filePath,String path);

    /**
     * 删除文件或目录
     * @param path
     * @return
     */
    boolean delete(String path);

    /**
     * 下载文件
     * @param filePath hadoop上文件的路径
     * @param path 下载到本地的位置
     * @return
     */
    boolean download(String filePath,String path);


}
