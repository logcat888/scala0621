package com.atguigu.scala.chapter08

/**
 * @author chenhuiup
 * @create 2020-09-20 14:52
 */
/*
1. List[Int]输入参数的类型，Option[Int]输出参数的类型，PartialFunction偏函数的类型，second偏函数名
2. 偏函数的函数体必须写在花括号内，因为他是Lambda表达式的进一步简写，省略了 变量 match,所以必须有{}，可以省略外面的圆括号
3. 偏函数的理解：有些情况处理，有些情况不处理，在全部场景下，只对一部分数据进行处理。对输入的数据进行模式匹配，符合条件的进行处理，
   不符合的不进行处理。
4. collect函数相当于是filter与map的结合，柯里化函数，第一个参数是偏函数，当Lambda表达式的函数体是模式匹配体，
   可以进一步简写，剩下的部分就是偏函数
   final override def collect[B, That](pf: PartialFunction[A, B])(implicit bf: CanBuildFrom[List[A], B, That]): That
 */
object Test06_PartialFunction {
  def main(args: Array[String]): Unit = {
    // List[Int]输入参数的类型，Option[Int]输出参数的类型，PartialFunction偏函数的类型，second偏函数名
    def second: PartialFunction[List[Int], Option[Int]] = {
      // x :: y :: _ 列表的表示方式，_相当于起别名，我们根本不关心这部分内容
      case x :: y :: _ => Some(y)
    }

    println(second.applyOrElse(List(1, 2, 3), (_: List[Int]) => None)) //Some(2)

    //需求：将该List(1,2,3,4,5,6,"test")中的Int类型的元素加一，并去掉字符串。
    val list = List(1, 2, 3, 4, 5, 6, "test")
    //下面map中的Lambda表达式可以转化为匿名函数，还可以继续简写
    println(list.map(x => x match {
      case i: Int => i + 1
      case _ =>
    }).filter(_.isInstanceOf[Int])) //List(2, 3, 4, 5, 6, 7)

    List(1, 2, 3, 4, 5, 6, "test").filter(_.isInstanceOf[Int]).map(_.asInstanceOf[Int] + 1).foreach(println)

    //偏函数的函数体必须写在花括号内，因为他是Lambda表达式的进一步简写，省略了 变量 match,所以必须有{}，可以省略外面的圆括号
    // 1.偏函数只对满足匹配条件的集合元素进行处理，不符合的过滤掉,只处理某些场景下的数据。
    // 2.collect函数相当于是filter与map的结合，柯里化函数，第一个参数是偏函数，当Lambda表达式的函数体是模式匹配体，可以进一步简写，剩下的部分就是偏函数
//    final override def collect[B, That](pf: PartialFunction[A, B])(implicit bf: CanBuildFrom[List[A], B, That]): That
    list.collect({ case i: Int => i + 1}).foreach(println)
    list.collect{ case i: Int => i + 1}.foreach(println)
  }
}
