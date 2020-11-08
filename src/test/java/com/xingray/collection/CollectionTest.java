package com.xingray.collection;

import com.xingray.javabase.result.Result;
import org.junit.Test;

public class CollectionTest {

    @Test
    public void isEmptyTest() {
        assert CollectionUtil.isEmpty((Object[]) null) == true;
    }

    @Test
    public void test01() {
        System.out.println(Result.OK);
    }
}
