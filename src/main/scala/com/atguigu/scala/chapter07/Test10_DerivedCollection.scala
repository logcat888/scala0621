package com.atguigu.scala.chapter07

/**
 * @author chenhuiup
 * @create 2020-09-18 23:49
 */
/*
1. 衍生集合的返回值为一个新集合，原集合不变。
2. 取头（一个元素）与尾（集合），要求必须有序，取一个元素和集合的目的就是为了方便递归
3. list做union直接追加，set会去重
4. 滑窗函数sliding(size,step)，size代表窗口大小，step代表滑动步长，默认步长为1。当窗口大小=滑动步长，称为滚动窗口。
 */
object Test10_DerivedCollection {
  def main(args: Array[String]): Unit = {
    val list1 = List(23, 54, 68, 91, 15)
    val list2 = List(35, 48, 69, 54, 23, 91, 102, 68, 231, 563)
      //  （1）获取集合的头
    println(list1.head) // 23

      //  （2）获取集合的尾（不是头的就是尾）
    println(list1.tail) // List(54, 68, 91, 15)
      //  （3）集合最后一个数据
    println(list1.last) // 15
      //  （4）集合初始数据（不包含最后一个）
    println(list1.init) // List(23, 54, 68, 91)
      //  （5）反转
    println(list1.reverse) // List(15, 91, 68, 54, 23)
      //  （6）取前（后）n个元素
    println(list1.take(2)) // List(23, 54)
    println(list1.takeRight(2)) //List(91, 15)
      //  （7）去掉前（后）n个元素
    println(list1.drop(2)) //List(68, 91, 15)
    println(list1.dropRight(2)) //List(23, 54, 68)
      //  （8）并集
    println(list1.union(list2)) //List(23, 54, 68, 91, 15, 35, 48, 69, 54, 23, 91, 102, 68, 231, 563)
      //  （9）交集
    println(list1.intersect(list2)) //List(23, 54, 68, 91)
    //  （10）差集
    println(list1.diff(list2)) // List(15)
    println(list2.diff(list1)) //List(35, 48, 69, 102, 231, 563)
      //  （11）拉链
    println(list1.zip(list2))
    println(list2.zip(list1))
    println(list1.zip(list1))
      //  （12）滑窗
    println(list1.sliding(2,3).foreach(elem => print(elem + "\t"))) //值传递，返回值为Unit,所以会打印出一个()
    println()
    println(list1.sliding(3,3).foreach(elem => print(elem + "\t")))

  }
}
