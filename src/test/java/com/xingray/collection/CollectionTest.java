package com.xingray.collection;

import com.xingray.javabase.interfaces.IntMapper;
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
        public String fullName;

        public People(String name, String fullName) {
            this.name = name;
            this.fullName = fullName;
        }
    }

    @Test
    public void test04() {
        List<People> peoples = List.of(new People("alex12", "ABC alex 222"),
                new People("blue234", "ASD blue 4343"),
                new People("coco1", "RFV coco 5455453")
        );

        IntRange nameLengthRange = CollectionUtil.intMinMax(peoples,
                new IntMapper<People>() {
                    @Override
                    public int map(People people) {
                        return people.name.length();
                    }
                }, new IntMapper<People>() {
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
                        return people.fullName.length();
                    }
                }, new IntMapper<People>() {
                    @Override
                    public int map(People people) {
                        return people.fullName.length();
                    }
                });

        System.out.println(fullNameLengthRange);
        assert fullNameLengthRange.getStart() == 12;
        assert fullNameLengthRange.getEnd() == 16;
    }
}
