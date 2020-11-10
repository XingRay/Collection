package com.xingray.collection;

import com.xingray.collection.array.DoubleArray;
import com.xingray.javabase.interfaces.IntMapper;
import com.xingray.javabase.range.DoubleRange;
import com.xingray.javabase.range.IntRange;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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


    @Test
    public void test03() {
        int[] values = {10, 3, 63, 23, 53, 62, 85, 87, 76, 45, 65};
        IntRange intRange = CollectionUtil.intMinMax(values);
        System.out.println(intRange);
        assert intRange.getStart() == 3;
        assert intRange.getEnd() == 87;
    }

    static class People {
        public String name;
        public String nickName;

        public People(String name, String nickName) {
            this.name = name;
            this.nickName = nickName;
        }
    }

    @Test
    public void test04() {
        List<People> peoples = List.of(new People("alex22", "alex222"),
                new People("blue234", "234"),
                new People("coco1", "cocococo111")
        );

        IntRange nameLengthRange = CollectionUtil.intMinMax(peoples,
                new IntMapper<People>() {
                    @Override
                    public int map(People people) {
                        return people.name.length();
                    }
                });
        System.out.println(nameLengthRange);
        assert nameLengthRange.getStart() == 5;
        assert nameLengthRange.getEnd() == 7;

        IntRange fullNameLengthRange = CollectionUtil.intMinMax(peoples,
                new IntMapper<People>() {
                    @Override
                    public int map(People people) {
                        return Math.min(people.name.length(), people.nickName.length());
                    }
                }, new IntMapper<People>() {
                    @Override
                    public int map(People people) {
                        return Math.max(people.name.length(), people.nickName.length());
                    }
                });

        System.out.println(fullNameLengthRange);
        assert fullNameLengthRange.getStart() == 3;
        assert fullNameLengthRange.getEnd() == 11;
    }

    @Test
    public void test05() {
        List<DoubleArray> arrays = List.of(DoubleArray.of(21, 15, 53), DoubleArray.of(11, 64, 72), DoubleArray.of(63, 12, 45));
        DoubleRange range = CollectionUtil.getRangeOfDoubleSeriesList(arrays);
        System.out.println(range);
        assert range != null;
        assert range.getStart() == 11;
        assert range.getEnd() == 72;
    }
}
