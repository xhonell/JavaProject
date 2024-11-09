package com.xhonell.entity;

import lombok.Data;

@Data
public class TbClassify {

    private long claId;
    private String claName;


    /**
     * TbClassify类的构造函数。
     * <p>
     * 这是一个无参构造函数，用于初始化TbClassify对象。
     */
    public TbClassify() {
    }

    /**
     * TbClassify的构造函数
     *
     * @param claId 分类ID
     * @param claName 分类名称
     */
    public TbClassify(long claId, String claName) {
        this.claId = claId;
        this.claName = claName;
    }
}
