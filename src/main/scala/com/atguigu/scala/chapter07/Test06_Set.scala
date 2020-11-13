package com.atguigu.scala.chapter07

import scala.collection.mutable

/**
 * @author chenhuiup
 * @create 2020-09-18 20:43
 */
/*
一、不可变Set
1. Set是一种特质, 无序，有去重功能，使用伴生对象创建对象。Set默认是immutable
2. Set添加元素 + ,由于无序所以，没有所谓的前加后加，每次返回一个新集合，原集合不变
3. Set合并集合 ++ , 原集合不变，返回一个新集合
4. Set删除元素 - , 原集合不变，返回一个新集合

二、可变Set
1. 可变Set添加元素： 1） +  原集合不变，返回一个新可变集合,底层使用clone；2）+= 原集合改变，返回值是当前对象，说明可以链式操作；
   3）add（elem） 只能添加一个元素返回值是Boolean类型
2. 删除元素： 1） -= ;2)remove(elem) 返回值是Boolean类型
3. 合并两个Set： 1） set1 ++= set2 , set1加上set2，set1变，set2不会；2）val set3 = set1.union(set2)，原集合不变，返回一个新集合
 */

object Test06_Set {
  def main(args: Array[String]): Unit = {
    // 一、不可变Set
    // 1.  创建Set
    val set1 = Set(1, 2, 3, 4, 5)
    println(set1) //Set(5, 1, 2, 3, 4)

    // 2. 添加元素，得到一个新的set
    val set2 = set1 + 7 + 8
    println(set1) //Set(5, 1, 2, 3, 4)
    println(set2) //Set(5, 1, 2, 7, 3, 8, 4)

    println("===========================")

    // 3. 合并set
    val set3 = Set(1,2,3,10)
    val set4 = set1 ++ set3
    println(set1) //Set(5, 1, 2, 3, 4)
    println(set3) //Set(1, 2, 3, 10)
    println(set4) //Set(5, 10, 1, 2, 3, 4)

    // 4. 删除元素
    val set5 = set4 - 10
    println(set4) //Set(5, 10, 1, 2, 3, 4)
    println(set5) //Set(5, 1, 2, 3, 4)

    // 二、可变set
    // 1. 创建set
    val set6:mutable.Set[Int] = mutable.Set(1,2,3,4,5)
    println(set6) //Set(1, 5, 2, 3, 4)

    // 2. 添加元素
    val set7 = set6 + 10 //set7 类型为mutable.Set[Int]
    println(set6) //Set(1, 5, 2, 3, 4)
    println(set7) //Set(1, 5, 2, 3, 10, 4)

    set6 += 2 += 12
    val flag = set6.add(11)
    println(set6) // Set(12, 1, 5, 2, 3, 4, 11)
    println(flag) //true

    // 3. 删除元素
    set6 -= 12
    println(set6) //Set(1, 5, 2, 3, 4, 11)
    val flag2 = set6.remove(5)
    val flag3 = set6.remove(5)
    println(set6) //Set(1, 2, 3, 4, 11)
    println(flag2) //true
    println(flag3) //false

    // 4. 合并两个set
    val set8 = mutable.Set(2,3,4,7,8)
    set6 ++= set8
    println(set6) //Set(1, 2, 3, 7, 4, 11, 8)
    println(set8) //Set(2, 3, 7, 4, 8)

    set8 += 15
    val set9 = set6.union(set8)
    println(set9) //Set(15, 1, 2, 3, 7, 4, 11, 8)

    // 5. 遍历
    for (elem <- set9) {
      print(elem + "\t")
    }
    println()

    set9.foreach(println)
  }
}
