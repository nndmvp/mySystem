package niannian.mysystem.dao.impl;/**
 * @author niannianda
 */

import niannian.mysystem.dao.FilesDao;
import niannian.mysystem.pojo.Vo.Files;
import niannian.mysystem.pojo.Vo.MyDirectory;
import niannian.mysystem.pojo.Vo.MyFile;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @title: FilesDaoImpl
 * @Author Tan
 * @Date: 2023/2/27 17:00
 * @Version 1.0
 */
@Repository
public class FilesDaoImpl implements FilesDao {
    @Override
    public FileSystem getSystem() {
        //获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fileSystem = null;
        try {
            fileSystem = FileSystem.get(new URI("hdfs://hadoop102:8020"),
                    configuration, "niannian");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return fileSystem;
    }

    @Override
    public Files getFiles(String path) {
        //获取文件系统
        FileSystem fileSystem = getSystem();

        //数据中的变量
        Integer directoryNum = 0;
        Integer fileNum = 0;
        List<MyDirectory> directoryList =new ArrayList<>();
        List<MyFile> fileList = new ArrayList<>();

        //查询数据并填入
        try {
            //获取所有文件与目录
            FileStatus[] fileStatuses = fileSystem.listStatus(new Path(path));

            //遍历所有文件与目录
            for (FileStatus fileStatus : fileStatuses) {
                //如果是文件
                if (fileStatus.isFile()){
                    //文件数+1
                    fileNum++;

                    //创建文件对象
                    MyFile myFile = new MyFile();
                    myFile.setName(fileStatus.getPath().getName());
                    myFile.setPath(fileStatus.getPath().toString());
                    myFile.setSize(Long.toString(fileStatus.getBlockSize()));

                    //传入fileList
                    fileList.add(myFile);
                } else {
                    //如果是目录
                    //目录数+1
                    directoryNum++;

                    //创建目录对象
                    MyDirectory myDirectory = new MyDirectory();
                    myDirectory.setName(fileStatus.getPath().getName());
                    myDirectory.setPath(fileStatus.getPath().toString());

                    //传入directoryList
                    directoryList.add(myDirectory);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //创建要返回的数据
        Files files = new Files(directoryNum,fileNum,directoryList,fileList);

        try {
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

    @Override
    public boolean isExist(String name, String path) {
        //获取文件系统
        FileSystem fileSystem = getSystem();
        boolean flag = false;

        try {
            if (fileSystem.exists(new Path(path+name))){
                flag = true;
            } else {
                flag = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean upload(String filePath,  String path) {
        //获取文件系统
        FileSystem fileSystem = getSystem();

        //上传文件
        try {
            fileSystem.copyFromLocalFile(new Path(filePath),new Path(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean delete(String path) {
        //获取文件系统
        FileSystem fileSystem = getSystem();

        //递归地删除目录和文件
        try {
            fileSystem.delete(new Path(path),true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean download(String filePath, String path) {
        //获取文件系统
        FileSystem fileSystem = getSystem();

        //下载文件系统
        try {
            fileSystem.copyToLocalFile(false,new Path(filePath),new Path(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
