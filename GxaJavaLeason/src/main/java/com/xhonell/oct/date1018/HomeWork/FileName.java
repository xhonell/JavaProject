package com.xhonell.oct.date1018.HomeWork;

public class FileName {
    private String fileName;

    public FileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        if (fileName.equals("E:\\2百杰班\\183\\一阶段二维数组.png"))
            return "文件名称：" + "一阶段二维数组.png";
        return "文件名称错误";
    }
}
