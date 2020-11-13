package com.atguigu.scala.chapter07

import scala.collection.mutable

/**
 * @author chenhuiup
 * @create 2020-09-19 22:37
 */
/*
1. groupBy(elem => elem)不能简写成groupBy( )，会产生误解
2. Map中的元素是二元组类型，取出的元素是(k,v)，kv的方式也可以是元组访问元素的方式_.1,_.2
3. 排序要求集合必须是有序的，Map/Set都是无序的，必须先转换成List，才能进行排序
4. List[(String,Int)], list.sortWith(_._2 > _._2), _._2 代表取list集合中的二元组类型的元素的第二个参数，进行比较Comparator比较
5. 字符串是可以乘以一个数的，表示出现的次数
6. List[(String,Int)], list.sortBy(_._2)(Ordering[Int].reverse), _._2
   代表取list集合中的二元组类型的元素的第二个参数，Ordering[Int].reverse隐式参数，降序排列
 */
object Test15_WordCount {
  def main(args: Array[String]): Unit = {
    // 一、简单版本
    val textLines: List[String] = List(
      "hello",
      "hello world",
      "hello scala",
      "hello spark",
      "hello spark from scala",
      "hello flink spark from scala"
    )

    //自己的版本
    //    println(textLines.flatMap(_.split(" ")).groupBy(elem => elem)
    //      .map(kv => (kv._1, kv._2.length)).toList.sortWith(_._2 > _._2).take(3))

    // 1. 分词
    //    val wordList: List[String] = textLines.map( _.split(" ") ).flatten
    val wordList: List[String] = textLines.flatMap(_.split(" "))
    println(wordList)
    //List(hello, hello, world, hello, scala, hello, spark, hello, spark, from, scala, hello, flink, spark, from, scala)

    // 2. 分组（按照word本身）
    val groupedWordMap: Map[String, List[String]] = wordList.groupBy(word => word)
    println(groupedWordMap)
    //Map(world -> List(world), flink -> List(flink), spark -> List(spark, spark, spark),
    // scala -> List(scala, scala, scala), from -> List(from, from).....

    // 3. 统计每个key的value的个数
    val wordCountMap: Map[String, Int] = groupedWordMap.map(kv => (kv._1, kv._2.size))
    println(wordCountMap)
    //Map(world -> 1, flink -> 1, spark -> 3, scala -> 3, from -> 2, hello -> 6)

    // 4. 排序取Top N
    val topNWordCountList: List[(String, Int)] = wordCountMap
      .toList
      .sortBy(_._2)(Ordering[Int].reverse)
      .take(3)

    println(topNWordCountList)
    //List((hello,6), (spark,3), (scala,3))

    println("=======================================")

    // 二、复杂版本
    val lineCountTupleList: List[(String, Int)] = List(
      ("hello", 1),
      ("hello world", 2),
      ("hello scala", 3),
      ("hello spark from scala", 4)
    )
    println("*****************************************************")
    // 自己编写
    println(lineCountTupleList.flatMap(kv => {
      ((kv._1.trim + " ") * kv._2).split(" ")
    }).groupBy(data => data).map(kv => (kv._1, kv._2.length)).
      toList.sortBy(kv => kv._2)(Ordering[Int].reverse).take(3))
    //效率低，没有利用原本("hello scala", 3)出现的次数，将其打散后重新进行计算

    val newList: List[mutable.Map[String, Int]] = lineCountTupleList.map(kv => {
      val map = mutable.Map[String, Int]()
      for (elem <- kv._1.trim.split(" "))
        map(elem) = kv._2
      map
    })

    println(newList.flatten.groupBy(_._1).map(kv => {
      val k = kv._1
      var sum = 0
      for (elem <- kv._2)
        sum += elem._2
      (k, sum)
    }).toList.sortBy(_._2)(Ordering[Int].reverse).take(3))


  }
}
