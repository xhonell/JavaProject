package com.xhonell.oct.date1025;


/**
 * <p>Project:JavaProject - FileTools
 * <p>POWER by xhonell on 2024-10-25 10:59
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class FileTools {

    /**
     * 根据文件路径获取文件全称
     *
     * @param path 文件的路径
     * @return 文件全称
     */
    public static String getFullFileName(String path) {
        int index = path.lastIndexOf("/");
        if (index == -1) {
            index = path.lastIndexOf("\\");
        }
        if (index == -1) {
            return path;
        }
        return path.substring(index + 1);
    }

    /**
     * 根据文件路径获取文件,名字
     *
     * @param path 文件的路径
     * @return 文件名字
     */
    public static String getFileName(String path) {
        String fileName = getFullFileName(path);
        int index = fileName.lastIndexOf(".");
        if (index != -1)
            return fileName.substring(0, index);
        return fileName;
    }

    /**
     * 返回文件的后缀
     *
     * @param path 文件路径
     * @return 后缀
     */
    public static String getSuffix(String path) {
        String fullFileName = getFullFileName(path);
        int index = fullFileName.lastIndexOf(".");
        if (index != -1)
            return fullFileName.substring(index);
        return "";
    }
}
