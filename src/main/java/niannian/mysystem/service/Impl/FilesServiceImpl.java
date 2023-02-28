package niannian.mysystem.service.Impl;/**
 * @author niannianda
 */

import niannian.mysystem.dao.impl.FilesDaoImpl;
import niannian.mysystem.pojo.Vo.Files;
import niannian.mysystem.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @title: FilesServiceImpl
 * @Author Tan
 * @Date: 2023/2/27 20:18
 * @Version 1.0
 */
@Service
public class FilesServiceImpl implements FilesService {

    private final FilesDaoImpl filesDao;

    public FilesServiceImpl(FilesDaoImpl filesDao) {
        this.filesDao = filesDao;
    }

    @Override
    public Files getFiles(String path) {
        Files files = filesDao.getFiles(path);
        return files;
    }
}
