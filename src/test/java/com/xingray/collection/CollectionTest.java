package com.xingray.collection;

import com.xingray.javabase.result.Result;
import org.junit.Test;

import java.util.ArrayList;

public class CollectionTest {

    @Test
    public void isEmptyTest() {
        //noinspection ConstantConditions
        assert CollectionUtil.isEmpty((Object[]) null);
    }

    @Test
    public void test01() {
        assert CollectionUtil.isEmpty(new ArrayList<>());
    }


}
