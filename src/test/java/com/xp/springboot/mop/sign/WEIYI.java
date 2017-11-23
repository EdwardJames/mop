package com.xp.springboot.mop.sign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WEIYI {

    public WEIYI() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        int a = 100;
        System.out.println(a/2);
        System.out.println(a>>=1);
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        List safeList = Collections.synchronizedList(list);
        System.out.println(safeList);
    }

}
