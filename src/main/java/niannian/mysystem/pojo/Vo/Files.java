package niannian.mysystem.pojo.Vo;/**
 * @author niannianda
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @title: File
 * @Author Tan
 * @Date: 2023/2/25 12:28
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Files {
    /**
     * 当前路径目录总数
     */
    private Integer directoryNum;
    /**
     * 当前路径文件总数
     */
    private Integer fileNum;
    /**
     * 当前页的目录集合
     */
    private List<MyDirectory> directoryList;
    /**
     * 当前页的文件集合
     */
    private List<MyFile> fileList;

}
