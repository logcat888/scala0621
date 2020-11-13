package com.atguigu.scala.chapter05

/**
 * 1. 函数可以作为值进行传递
 *    注：1）在被调用函数foo后面加上 _，相当于把函数foo当成一个整体，传递给变量f1
 *       2）如果明确变量类型，那么不使用下划线也可以将函数作为整体传递给变量
 *       3） 用f2接收函数对象，因为f2是一个变量，指向函数对象，所以必须使用参数列表才能调用函数，
 *           不同于无参的函数名，能够直接通过函数名省略（）调用
 * 2. 函数可以作为参数进行传递
 * 3. 函数可以作为函数返回值返回
 *    注：3.1 当函数返回值已经明确，返回的函数可以不使用 _ ,将函数作为一个整体
 *        3.2 当函数返回值不明确（类型推断），返回的函数必须使用 _ ,将函数作为一个整体
 *
 *
 * @author chenhuiup
 * @create 2020-09-14 22:06
 */
object Test06_HighLevelFunction {
  def main(args: Array[String]): Unit = {
    //函数正常声明
    def f(): Int = {
      println("f()")
      10
    }

    //函数的调用和函数返回值
    f() //f()
    f //f()
    println(f()) // f() 10

    //1. 函数可以作为值进行传递
    //1.1 在被调用函数foo后面加上 _，相当于把函数foo当成一个整体，传递给变量f1
    val f1 = f _
    println(f1) //com.atguigu.scala.chapter05.Test06_HighLevelFunction$$$Lambda$5/804581391@c818063

    //1.2 如果明确变量类型，那么不使用下划线也可以将函数作为整体传递给变量
    val f2: () => Int = f
    println(f2) //com.atguigu.scala.chapter05.Test06_HighLevelFunction$$$Lambda$6/1057941451@75bd9247
    f2 // f2是一个变量，指向函数对象，所以必须使用参数列表才能调用函数，不同于无参的函数名，能够直接通过函数名省略（）调用
    f2() // f()

    // 2. 函数可以作为参数进行传递
    def dualFunction(a: Int, b: Int, op: (Int, Int) => Int): Int = {
      op(a, b)
    }

    println(dualFunction(12, 15, _ + _))
    println(dualFunction(12, 15, _ * _))

    // 3. 函数可以作为函数返回值返回
    def f3_1(): () => Unit = {
      () => {
        println("哈哈")
      }
    }

    f3_1()()

    //3.1 当函数返回值已经明确，返回的函数可以不使用 _ ,将函数作为一个整体
    def f3(): () => Unit = {
      def f4(): Unit = {
        println("f4()")
      }
      f4
    }

    //3.2 当函数返回值不明确（类型推断），返回的函数必须使用 _ ,将函数作为一个整体
    def f7() ={
      def f4(): Unit = {
        println("f4()")
      }
      f4 _
    }

    //f5其实就是f4
    val f5 = f3()
    println(f5) //com.atguigu.scala.chapter05.Test06_HighLevelFunction$$$Lambda$10/1809787067@6b71769e
    f5()  // f4()

    f3()()  // f4()



  }

}
