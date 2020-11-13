package com.atguigu.scala.chapter07

/**
 * @author chenhuiup
 * @create 2020-09-18 23:37
 */
/*
1. Set集合没有length方法,length和szie方法没有区别
2.
 */
object Test09_CommonOperation {
  def main(args: Array[String]): Unit = {
    val list = List(23, 54, 68, 91, 15)
    val set = Set(1,2,3,4,5,6)
    val arr = new Array[Int](5)

    //    （1）获取集合长度
    println(list.length) //5
    println(arr.length) //5

    //    （2）获取集合大小
    println(list.size) //5
    println(set.size) //6
    println(arr.size) //5
    //    （3）循环遍历
    list.foreach(elem => print(elem + "\t"))
    println()
    set.foreach(elem => print(elem + "\t"))
    println()
    //    （4）迭代器
    var iter = list.iterator
    while (iter.hasNext)
      println(iter.next()  + "\t")
    println()
    //    （5）生成字符串
    println(list.mkString("[", "-", "]")) //[23-54-68-91-15]
    //    （6）是否包含
    println(list.contains(15)) //true
  }

}
