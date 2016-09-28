package com.lysehun.diary;

import java.io.Serializable;

/**
 * Created by lysehun on 2016/9/26.
 */

public class SaveObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private String dairytext;
    private int btnnum;

    public String getDairytext() {
        return dairytext;
    }
    public void setDairytext(String dairytext) {
        this.dairytext = dairytext;
    }
    public int getBtnnum() {
        return btnnum;
    }
    public void setBtnnum(int btnnum) {
        this.btnnum = btnnum;
    }
}
