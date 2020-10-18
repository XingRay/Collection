package com.xingray.collection;

/**
 * @author : leixing
 * @date : 2018/6/22 17:39
 * <p>
 * description : Mapper
 */
public interface IndexMapper<T, K> {
    K map(int index, T t);
}
