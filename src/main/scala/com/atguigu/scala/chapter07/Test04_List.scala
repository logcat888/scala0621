package com.atguigu.scala.chapter07

/**
 * //不可变列表
 *
 * @author chenhuiup
 * @create 2020-09-18 18:46
 */
/*
不可变列表说明
0. 已经在Predef包中预定义了类型，List就是 immutable.List
  type List[+A] = scala.collection.immutable.List[A]
  val List = scala.collection.immutable.List
  val Nil = scala.collection.immutable.Nil
  type ::[A] = scala.collection.immutable.::[A]
  val :: = scala.collection.immutable.::
1. List 是一个密封的抽象类 sealed abstract class List[+A] extends AbstractSeq[A]，
2. sealed是必须再同一个文件中继承，避免乱继承
3. List不能使用new的方式创建对象，可以使用伴生对象或空列表Nil的方式创建对象
4. 由于List继承了AbstractSeq，所以可以直接打印，输出类型（元素，元素，...），不像Array不在该类型系统中，必须使用mkString。
5. 由于List继承了LinearSeq[A]，所以没有索引，list(2)，是遍历查找第三个元素，不像索引直接定位。
6. Nil 代表一个空列表 case object Nil extends List[Nothing]，使用空List Nil 创建列表是scala推荐的方式
7. :: 方法表示在List前添加一个元素，返回一个新的List，在scala中以:结尾，调用是从右向左，右边是调用者，放在前面
8. :: 类 创建对象。会将 左边作为一个整体final case class ::[B](override val head: B, private[scala] var tl: List[B]) extends List[B]
9. List集合的扁平化处理的两种方法: 1) ::: 会将前面的集合打散，添加到后面集合的前面,scala 推荐的方法； 2） ++ 方法
 */
object Test04_List {
  def main(args: Array[String]): Unit = {
    // 1. 创建List
    val list1: List[Int] = List(1, 2, 3, 4, 5)
    println(list1) //List(1, 2, 3, 4, 5)
    println(list1(2)) // 3

    // 2. 添加元素，得到一个新的list
    println("=================================")
    val list2 = 7 +: list1 :+ 2
    val list3 = list2 :+ 39
    println(list1) //List(1, 2, 3, 4, 5)
    println(list2) //List(7, 1, 2, 3, 4, 5, 2)
    println(list3) //List(7, 1, 2, 3, 4, 5, 2, 39)

    // 3. 空列表以及创建列表的另一种方法
    //Nil 代表一个空列表 case object Nil extends List[Nothing]
    val list4 = 2 +: 4 +: 5 +: Nil :+ 3
    // :: 表示在List前添加一个元素，返回一个新的List，在scala中以:结尾，调用是从右向左，右边是调用者，放在前面
    val list5 = list1.::(50)
    val list5_1 = 50 :: list1
    println(list4) // List(2, 4, 5, 3)
    println(list5) // List(50, 1, 2, 3, 4, 5)
    println(list5_1) // List(50, 1, 2, 3, 4, 5)

    // 4. 合并两个列表，扁平化
    // :: 会将 左边作为一个整体
    // final case class ::[B](override val head: B, private[scala] var tl: List[B]) extends List[B]
    val list6 = list4 :: list5 //List 的类型为List[Any]
    println(list6) // List(List(2, 4, 5, 3), 50, 1, 2, 3, 4, 5)
    // ::: 会将前面的集合打散，添加到后面集合的前面
    val list7 = list4 ::: list5
    println(list7) // List(2, 4, 5, 3, 50, 1, 2, 3, 4, 5)

    val list8 = list4 ++ list5
    println(list8) // List(2, 4, 5, 3, 50, 1, 2, 3, 4, 5)

    // 5. 遍历
    list8.foreach(elem => print(elem + "\t"))
    println()
    for(elem <- list8) print(elem + "\t")
  }
}
