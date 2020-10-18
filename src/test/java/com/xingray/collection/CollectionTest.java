package com.xingray.collection;

import org.junit.Test;

public class CollectionTest {

    @Test
    public void isEmptyTest() {
        assert CollectionUtil.isEmpty((Object[]) null) == true;
    }
}
