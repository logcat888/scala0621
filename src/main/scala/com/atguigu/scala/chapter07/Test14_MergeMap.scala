package com.atguigu.scala.chapter07

import scala.collection.mutable

/**
 * @author chenhuiup
 * @create 2020-09-19 22:22
 */
object Test14_MergeMap {
  def main(args: Array[String]): Unit = {
    val map1 = mutable.Map("a" -> 1, "b" -> 12, "c" -> 32, "d" -> 25)
    val map2 = mutable.Map("a" -> 4, "b" -> 7, "d" -> 57, "e" -> 23)

    // 需求：合并之后得到("a" -> 5, "b" -> 19, "c" -> 32, "d" -> 82, "e" -> 23)
    // 用fold来实现，以map2作为初始值
    val result: mutable.Map[String, Int] = map1.foldLeft(map2)(
      // 操作函数，第一个参数aggMap是当前聚合之后的状态，保存在一个Map里；第二参数是当前数据，key-value对
      (aggMap, kv) => {
        // 先从数据中取出当前的key和value
        val key: String = kv._1
        val value: Int = kv._2
        // 判断当前状态map中是否有key，如果有就叠加value；如果没有就直接保存
        aggMap(key) = aggMap.getOrElse(key, 0) + value
        aggMap
      }
    )
    println(result)

    val test = mutable.Map[String,Int]()
    test("a") = 5
    println(test)

  }
}
