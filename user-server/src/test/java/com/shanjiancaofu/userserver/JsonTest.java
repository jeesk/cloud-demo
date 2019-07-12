package com.shanjiancaofu.userserver;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {


    @Test
    public void jsonTest() {
        Map<Object, Object> map = new HashMap<>();
        Object[] strLIst = new Object[]{1,2,4,5,6};
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);


        map.put("heloo", strLIst);
        map.put("world", list);

        Gson gson = new Gson();

        String s = gson.toJson(map);
        System.out.println(s);
    }
}
