package com.atguigu.scala.chapter07

import scala.collection.mutable

/**
 * @author chenhuiup
 * @create 2020-09-18 21:24
 */
/*
一、不可变Map
1. Map是一种特质，可以使用Map的伴生类创建对象，默认的map是immutable.Map
2. map本质是一个二元组
3. 访问数据：
   1）def get(key: K): Option[V] ；get的返回值是Option[V],有两个子类Some和None（空），
    使用Option的目的就是为了防止空指针。后面可以根据是否是None，进行判断，如果是None，给默认值。
   2）getOrElse[V1 >: V](key: K, default: => V1): V1 = get(key) ；getOrElse(key,默认值)，
    如果Map中没有这样的key，返回一个默认值
    3)使用def apply(key: K): V = get(key) match... apply可以省略 ，但是可能会空指针，不建议使用
 4. 遍历元素，1）map1.keys/values可以获取map中所有的key/values的iterator集合；2）map1.keySet获取key的Set集合；
    3）map1.keysIterator可以获取map中所有的key的iterator集合
 5. updated修改元素，如果key存在，返回一个新map,覆盖原来value，原map不变；如果key不存在，相当于添加元素

二、可变Map
1. map中的元素是二元组，也称为对偶，可以写成（"a" -> 1）键值对，也可以写出二元组形式（（a，1））
2. 可变map添加元素，可以修改key的value；
    1） += ,可以添加多个，其返回值类型为mutable.Map[String, Int],说明可以链式操作；
    2） put,只能添加一个键值对，其返回值类型为Option[Int]，如果添加key不存在，返回None，如果存在，返回Some(原来key对应的value)
3. 可变map删除元素：1） -= ，和+=类似； 2）remove(key)，返回值情况和put类似
4. 可变map修改元素：update与put效果一样，因为put底层使用的是update
5. 可变map合并：
   1） val map3 = map1 ++ map2 ，原集合map1/map2不变，产生新集合map3,如果有相同的key,后面的map的value覆盖前面的。
   2） map1 ++= map2, map1增加map2中的元素，后面的覆盖前面的，不会产生新集合，map2不变。要求map1必须是可变的。
6. 在大数据场景中的map，不应该是合并后覆盖，而是相加。
 */
object Test07_Map {
  def main(args: Array[String]): Unit = {
    // 一、不可变map
    // 1. 创建一个map
    val map1:Map[String,Int] = Map("a" -> 1, "b" -> 2, "c" -> 3, "d" -> 4)
    println(map1) //Map(a -> 1, b -> 2, c -> 3, d -> 4)

    // 2. 访问数据
    println(map1.get("a")) // Some(1)
    println(map1.get("e")) //None
//    println(map1.get("e").get) //NoSuchElementException
    println(map1.get("a").get) // 1
    println(map1.get("a").getOrElse(10)) // 1
    println(map1.getOrElse("e",10)) // 10
    println(map1("a")) // 1

    // 3. 遍历所有元素
    map1.foreach(print) //(a,1)(b,2)(c,3)(d,4)
    map1.foreach((elem:(String,Int))=>println(elem))
    map1.foreach(elem=>println(elem))
    for (elem <- map1) println(elem)

    for (key <- map1.keys)
      print(key + "--" + map1.getOrElse(key,0) + "\t") //a--1	b--2	c--3	d--4
    println()

    for (key <- map1.keysIterator)
      print(key + "--" + map1.getOrElse(key,0) + "\t") //a--1	b--2	c--3	d--4
    println()

    for (key <- map1.keySet)
      print(key + "--" + map1(key) + "\t") //a--1	b--2	c--3	d--4
    println()
    for( value <- map1.values ) print(value + "\t")
    println()
    println("=====================")

    // 4.修改元素，如果key存在，返回一个新map,覆盖原来value，原map不变；如果key不存在，相当于添加元素
    val map1_1: Map[String, Int] = map1.updated("a",2)
    val map1_2: Map[String, Int] = map1.updated("e",2)
    println(map1) //Map(a -> 1, b -> 2, c -> 3, d -> 4)
    println(map1_1) //Map(a -> 2, b -> 2, c -> 3, d -> 4)
    println(map1_2) //Map(e -> 2, a -> 1, b -> 2, c -> 3, d -> 4)

    println("==========================")
    // 二、可变map
    // 1. 创建
    val map2_1 = mutable.Map[String,Int]()
    val map2 = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3, "d" -> 4)
    println(map2_1) //Map()

    // 2. 添加元素
    val maybeInt: Option[Int] = map2.put("e",5)
    val map: mutable.Map[String, Int] = map2 += ("f"->6)
    map2 += (("f",7),("h",8))
    val maybeInt2: Option[Int] = map2.put("e",6)
    val maybeInt3: Option[Int] = map2.put("e",5)
    println(maybeInt) //None
    println(maybeInt2) //Some(5)
    println(maybeInt3) //Some(6)
    println(map2) //Map(e -> 5, h -> 8, b -> 2, d -> 4, a -> 1, c -> 3, f -> 7)
    // 3. 删除元素
    val maybeInt1: Option[Int] = map2.remove("d")
    map2 -= "e" -= "h"
    println(maybeInt1) //Some(4)
    println(map2) //Map(b -> 2, a -> 1, c -> 3, f -> 7)

    // 4. 修改map中value值
    // def update(key: K, value: V) { this += ((key, value)) }
    // def put(key: K, value: V): Option[V] = {
    //    val r = get(key)
    //    update(key, value)
    //    r
    //  }
    val unit: Unit = map2.update("b",5)
    map2.update("x",5)
    println(map2) //Map(b -> 5, a -> 1, x -> 5, c -> 3, f -> 7)
    println("=====================")
    // 5. 合并两个map
    println(map1) //Map(a -> 1, b -> 2, c -> 3, d -> 4)
    println(map2) //Map(b -> 5, a -> 1, x -> 5, c -> 3, f -> 7)

    val map3 = map1 ++ map2
    val map4 = map2 ++ map1
    println(map1) //Map(a -> 1, b -> 2, c -> 3, d -> 4)
    println(map2) //Map(b -> 5, a -> 1, x -> 5, c -> 3, f -> 7)
    println(map3) //Map(x -> 5, f -> 7, a -> 1, b -> 5, c -> 3, d -> 4)
    println(map4) //Map(b -> 2, d -> 4, a -> 1, x -> 5, c -> 3, f -> 7)

    println("=====================")
    map2 ++= map1
    println(map1) //Map(a -> 1, b -> 2, c -> 3, d -> 4)
    println(map2) //Map(b -> 2, d -> 4, a -> 1, x -> 5, c -> 3, f -> 7)

    val map5 = Map("a" -> List(1,1,1))
    map5.get("a").get.length
    println(map5("f").length) // 报错，会出现NoSuchElementException，必须使用getOrElse，必须空指针
    map5.getOrElse("a",Nil).length
    println(Nil.length)
  }
}
