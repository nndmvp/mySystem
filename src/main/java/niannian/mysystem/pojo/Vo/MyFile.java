package niannian.mysystem.pojo.Vo;/**
 * @author niannianda
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @title: MyFile
 * @Author Tan
 * @Date: 2023/2/25 13:06
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyFile {
    /**
     * 文件名
     */
    private String name;
    /**
     * 文件大小
     */
    private String size;

    /**
     * 路径
     */
    private String path;
}
