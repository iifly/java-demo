package io.iifly.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * ArrayList 使用示例
 *
 * @author zh-hq
 * @date 2023/2/17
 */
public class ArrayListDemo {


    public static void main(String[] args) {
        // init();
        // add();
        // set();
        remove();
        // other();
    }


    public static void init() {
        // 创建一个空集合，容量为 10
        ArrayList<Integer> l1 = new ArrayList<>();
        // 创建一个指定容量的空集合
        ArrayList<Integer> l2 = new ArrayList<>(5);
        // 创建一个集合，并把指定集合的元素按照迭代顺序添加到新建集合中
        ArrayList<Integer> l3 = new ArrayList<>(l2);

        // 此方式初始化的列表不支持修改
        List<Integer> l4 = Arrays.asList(1, 2);
        // l4.add(3);// 异常 java.lang.UnsupportedOperationException
    }

    public static void add() {
        ArrayList<Integer> l1 = new ArrayList<>();
        // 把指定元素添加到末尾
        l1.add(1);
        l1.add(4);
        System.out.println(l1);// [1, 4]

        // 向指定索引添加指定值，索引及之后的元素依次向后移动, index 不能大于集合 size
        l1.add(1, 2);
        System.out.println(l1);// [1, 2, 4]
        l1.add(2, 3);
        System.out.println(l1);// [1, 2, 3, 4]
        // l1.add(5, 6);// 此时集合 size=4， addIndex=5 会发生越界异常 java.lang.IndexOutOfBoundsException: Index: 5, Size: 4

        // 把指定集合的元素按照迭代顺序添加到集合末尾
        l1.addAll(Arrays.asList(7, 8, 9));
        System.out.println(l1);//[1, 2, 3, 4, 7, 8, 9]

        // 把指定集合的元素按照迭代顺序添加到指定索引处，索引及之后的元素依次向后移动
        l1.addAll(4, Arrays.asList(5, 6));
        System.out.println(l1);// [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    public static void set() {
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(l1);//[1, 2, 3]

        // 把指定索引处元素替换为指定值，index 需小于集合 size
        l1.set(0, 3);
        System.out.println(l1);//[3, 2, 3]
        l1.set(1, 4);
        System.out.println(l1);//[3, 4, 3]
        l1.set(2, 5);
        System.out.println(l1);//[3, 4, 5]
        // l1.set(3, 6);// index=3 size=3, 越界异常 java.lang.IndexOutOfBoundsException: Index: 3, Size: 3
    }

    public static void remove() {
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(0, 2, 5, 8, 9, 11, 2, 11, 24));
        System.out.println(l1);//[0, 2, 5, 8, 9, 11, 2, 11, 24]

        // 移除指定索引处元素，之后的元素向前移动
        l1.remove(2);
        System.out.println(l1);//[0, 2, 8, 9, 11, 2, 11, 24]
        // 移除与指定值相等的第一个元素，之后的元素向前移动
        l1.remove((Object) 2);
        System.out.println(l1);//[0, 8, 9, 11, 2, 11, 24]

        // 从此列表中移除指定集合中包含的所有元素
        l1.removeAll(Arrays.asList(4, 8, 10, 11, 15));
        System.out.println(l1);//[0, 9, 2, 24]

        // 从此列表中移除指定集合之外的所有元素
        l1.retainAll(Arrays.asList(0, 2, 24));
        System.out.println(l1);//[0, 2, 24]

        // 从此列表中移除满足条件的所有元素，如：移除大于5的元素
        /*l1.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 5;
            }
        });*/
        // 上面匿名内部类用 lambuda 简写
        l1.removeIf(i -> i > 5);
        System.out.println(l1);//[0, 2]
    }

    public static void other() {
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(0, 2, 5, 8, 9, 11, 2, 11, 24));
        System.out.println(l1);//[0, 2, 5, 8, 9, 11, 2, 11, 24]
        // 增加此的容量 <tt>数组列表</tt>实例，以确保它至少可以容纳由最小容量参数指定的元素数量。
        l1.ensureCapacity(20);
        // 获取索引处元素
        System.out.println(l1.get(3));// 8

        // 查找与指定值相等的第一个元素索引
        System.out.println(l1.indexOf(2));// 1

        // 查找与指定值相等的第一个元素索引
        System.out.println(l1.lastIndexOf(2));// 6

        // 列表中是否包含指定元素
        System.out.println(l1.contains(3));//false
        // 按整形自然顺序排序
        // l1.sort(Integer::compareTo);
        l1.sort(Comparator.naturalOrder());
        System.out.println(l1);//[0, 2, 2, 5, 8, 9, 11, 11, 24]
        // 按整形自然顺序相反的顺序排序
        l1.sort(Comparator.reverseOrder());
        System.out.println(l1);//[24, 11, 11, 9, 8, 5, 2, 2, 0]

        // 迭代遍历元素
        l1.forEach(System.out::print);//241111985220
        System.out.println();

        // 列表转换为数组
        System.out.println(Arrays.toString(l1.toArray()));// [24, 11, 11, 9, 8, 5, 2, 2, 0]

        // 将列表的容量调整为当前列表大小
        l1.trimToSize();

        // 返回指定的fromIndex （含）和toIndex之间的列表部分的视图
        // 所以此列表的任何修改都会反馈到原列表，
        List<Integer> subList = l1.subList(3, 5);
        System.out.println(subList);//[9, 8]

        // 判断列表是否为空
        System.out.println(subList.isEmpty());// false
        // 清空列表，移除所有元素
        subList.clear();
        System.out.println(subList.isEmpty());// true
        System.out.println(subList);//[]
        System.out.println(l1);//[24, 11, 11, 5, 2, 2, 0]

        // 但是如果修改原列表会导致 modCount 不相同而引发并发修改异常
        subList = l1.subList(3, 5);
        System.out.println(subList);//[5, 2]
        l1.add(6);
        // System.out.println(subList); // java.util.ConcurrentModificationException, 只有访问 subList 时才会抛出
    }
}
