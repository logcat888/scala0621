package com.atguigu.scala.chapter07

/**
 * @author chenhuiup
 * @create 2020-09-19 21:00
 */
/*
1. 过滤：def filter(p: A => Boolean): Repr = filterImpl(p, isFlipped = false)
   A为传入一个集合元素，如果为经过逻辑判断返回true则，留下该元素
2. 打印Array[String]时必须使用mkString，否则输出地址值
3. groupBy: def groupBy[K](f: A => K): immutable.Map[K, Repr],
   groupBy() 参数f: A => K， A为集合元素，K为分组逻辑，返回值为分组字段。
   整体groupBy的返回值是Map[K, Repr]集合，K为分组后的字段，Repr为同一组K的集合
4. String类也有apply方法，"hello"(0)代表取字符串的第一个元素，Char类型的
 */
object Test12_HighLevelFunction_Map {
  def main(args: Array[String]): Unit = {
    val list = List(35, 48, 69, 54, 23, 91, 102, 68, 231, 563)
    // 1. 过滤
    val evenList = list.filter(_ % 2 == 0) //List(48, 54, 102, 68)
    val oddList = list.filter(_ % 2 == 1) //List(35, 69, 23, 91, 231, 563)
    println(evenList)
    println(oddList)

    // 2. map
    val mul2List = list.map(_ * 2)
    println(mul2List) //List(70, 96, 138, 108, 46, 182, 204, 136, 462, 1126)

    // 3. 扁平化
    val nestedList: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))

    //使用List集合的 ：：：方法效率低
    val flatList1 = nestedList(0) ::: nestedList(1) ::: nestedList(2)
    println(nestedList.flatten) //List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // 4. 扁平映射
    val strings: List[String] = List("hello world", "hello scala", "hello atguigu", "hello atguigu with scala")
    val splitStrings: List[Array[String]] = strings.map(_.split(" "))
    println(splitStrings) // 打印Array[String]时必须使用mkString，否则输出地址值
    val flattenWordList: List[String] = splitStrings.flatten
    println(flattenWordList)

    // 将map和flatten合并为一步操作
    println(strings.flatMap(_.split(" ")))
    //List(hello, world, hello, scala, hello, atguigu, hello, atguigu, with, scala)

    // 5. 分组操作
    // def groupBy[K](f: A => K): immutable.Map[K, Repr]
    //groupBy() 参数f: A => K， A为集合元素，K为分组逻辑，返回值为分组字段。
    // 整体groupBy的返回值是Map[K, Repr]集合，K为分组后的字段，Repr为同一组K的集合
    val groupedMap: Map[Int, List[Int]] = list.groupBy(_ % 2)
    println(groupedMap)
    //Map(1 -> List(35, 69, 23, 91, 231, 563), 0 -> List(48, 54, 102, 68))

    // String类也有apply方法，"hello"(0)代表取字符串的第一个元素，Char类型的
   val groupedWordMap:Map[Char,List[String]] =  flattenWordList.groupBy(_(0))
    println(groupedWordMap)
    //Map(w -> List(world, with), h -> List(hello, hello, hello, hello),
    // s -> List(scala, scala), a -> List(atguigu, atguigu))
  }

}
