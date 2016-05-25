package br.com.orbetail.gettrainee.test.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class InplaceView implements Serializable {

    private String text = "PrimeFaces";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}