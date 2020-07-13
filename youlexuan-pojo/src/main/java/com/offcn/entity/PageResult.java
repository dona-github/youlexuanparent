package com.offcn.entity;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {
        //每一页显示的总记录数
        private long total;
        //每一页展示的结果(行数)
        private List rows;
        //生成空参有参构造函数以及getter setter方法
        //加super的原因:方便调用父类的方法(父类初始化)

    public PageResult() {
        super();
    }

    public PageResult(long total, List rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
