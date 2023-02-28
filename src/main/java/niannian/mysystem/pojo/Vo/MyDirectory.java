package niannian.mysystem.pojo.Vo;/**
 * @author niannianda
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @title: MyDirectory
 * @Author Tan
 * @Date: 2023/2/25 13:05
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyDirectory {
    /**
     * 目录名
     */
    private String name;

    /**
     * 路径
     */
    private String path;
}
