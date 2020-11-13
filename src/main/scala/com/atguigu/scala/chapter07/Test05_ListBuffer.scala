package com.atguigu.scala.chapter07

import scala.collection.mutable.ListBuffer

/**
 * @author chenhuiup
 * @create 2020-09-18 19:30
 */
/*
可变列表ListBuffer
1. 创建一个可变列表的方式：1）new的方式；2）使用伴生对象ListBuffer
2. 添加元素的方式 append() prepend() insert(index，elem)  +=(后加) +=:（前加）
3. += 会返回一个ListBuffer集合，原集合和新集合一模一样
4. List集合可以重复
5. 合并两个列表: 1) ++ 方法 val list3 = list1 ++ list2  list1和list2不变,list3为新集合 ；2）++= （后加，前面是调用者） ++=：（前加，后面是调用者）
6. 删除元素：1）remove（index）是删除所有位置元素；2）-= value 删除第一个值为value的元素
7. 访问和修改元素: 1)查找元素apply(index),apply可省略；2）修改元素update(index,value),可以简写list(index) = value
8. ++方法底层调用clone（）方法; 删除元素 方法 - ，底层也会调用clone方法，返回一个新集合。
 */
object Test05_ListBuffer {
  def main(args: Array[String]): Unit = {
    // 1. 创建一个可变列表
    val list1: ListBuffer[Int] = new ListBuffer[Int]()
    val list2 = ListBuffer(1, 2, 3, 4, 5)
    println(list1) //ListBuffer()
    println(list2) //ListBuffer(1, 2, 3, 4, 5)

    // 2. 添加元素
    //        val list = 23 :: list1.toList //返回一个不可变集合
    val list: ListBuffer[Int] = list1 += 2
    println(list1) //ListBuffer(2)
    println(list) //ListBuffer(2)

    // 在集合后添加元素
    list1.append(7, 8, 9)
    // 向集合前添加元素
    list1.prepend(1, 2, 3)
    // 向指定索引插入元素
    list1.insert(1, 12)
    println(list1) //ListBuffer(1, 12, 2, 3, 2, 7, 8, 9)

    5 +=: list
    println(list) // ListBuffer(5, 1, 12, 2, 3, 2, 7, 8, 9)
    println(list == list1) //true
    println("=========================")

    // 3. 合并两个列表
    //def ++(xs: GenTraversableOnce[A]): This = clone() ++= xs.seq
    val list3 = list1 ++ list2
    println(list1) //ListBuffer(5, 1, 12, 2, 3, 2, 7, 8, 9)
    println(list2) //ListBuffer(1, 2, 3, 4, 5)
    println(list3) //ListBuffer(5, 1, 12, 2, 3, 2, 7, 8, 9, 1, 2, 3, 4, 5)

    list1 ++= list2
    println(list1) //ListBuffer(5, 1, 12, 2, 3, 2, 7, 8, 9, 1, 2, 3, 4, 5)
    println(list2) //ListBuffer(1, 2, 3, 4, 5)

    list1 ++=: list2
    println(list1) //ListBuffer(5, 1, 12, 2, 3, 2, 7, 8, 9, 1, 2, 3, 4, 5)
    println(list2) //ListBuffer(5, 1, 12, 2, 3, 2, 7, 8, 9, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5)

    // 4. 删除元素
    list1.remove(5)
    println(list1) //ListBuffer(5, 1, 12, 2, 3, 7, 8, 9, 1, 2, 3, 4, 5)
    list1 -= 5
    println(list1) //ListBuffer(1, 12, 2, 3, 7, 8, 9, 1, 2, 3, 4, 5)

    val list4 = ListBuffer(1,2,3,4)
    val list5 = list4 - 3
    println(list5) //ListBuffer(1, 2, 4)

    // 5. 访问和修改元素
    list1(0) = 15
    list1.update(1,20)
    println(list1(0)) // 15
    println(list1) //ListBuffer(15, 20, 2, 3, 7, 8, 9, 1, 2, 3, 4, 5)
  }

}
