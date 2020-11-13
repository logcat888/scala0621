package com.atguigu.scala.chapter08

/**
 * @author chenhuiup
 * @create 2020-09-20 11:32
 */
/*
一、变量声明时的模式匹配：
1. val (id,name,age) = (9527, "DongLiang", 18) 变量name，age可以直接使用
二、for推导式中的模式匹配
1. elem<-list，elem为最简单的模式匹配，用一个元素接收变量
 */
object Test03_MatchExtendCase {
  def main(args: Array[String]): Unit = {
    // 1.变量声明时的模式匹配
    // 元组形式
    val (x, y): (Int, Int) = (1, 2)
    val (id, name, age) = (9527, "DongLiang", 18)
    println(name) //DongLiang

    // 列表形式
    //    val list(first,second,_*) = List(1,2,3,4,5) //error
    val List(first, second, _*) = List(1, 2, 3, 4, 5)
    println(first) // 1

    // 2.for推导式中的模式匹配
    val list: List[(String, Int)] = List(("a", 1), ("b", 2), ("c", 3))

    //本来的遍历方式
    for (elem <- list)
      println(elem._1, elem._2)

    for (elem <- list) {
      val word = elem._1
      val count = elem._2
    }

    // 用元组的模式匹配
    for ((word, count) <- list) {
      println(word + " " + count)
    }

    //可以不考虑某些位置
    for ((word, _) <- list) {
      println(word)
    }

    // 可以直接指定某个字段的值
    for (("b", count) <- list) {
      println("b count: " + count)
    }
  }

}
