package com.atguigu.scala.chapter05

/**
 * 1. 值调用在传入参数时已经确定值，因此一直为true，所以会陷入死循环
 * 2. 匿名函数简写的方法：先写出完整的函数，返回值类型确定。这样就可以删除函数的定义，形参类型，返回值类型，=变成=>
 * 3. 函数柯里化是针对分层级函数，外层函数返回内层函数，内层函数依赖外层函数参数，只有最内层函数做操作。柯里化一定实现了闭包。
 * 4. 函数柯里化只需要写出各层级的参数列表、最终的返回值，以及最内层的逻辑即可。
 * 5. 如何写出优雅的代码，先写出复杂的，再结合函数至简原则优化。
 *
 * @author chenhuiup
 * @create 2020-09-15 19:31
 */
object Test12_MyWhile {
  def main(args: Array[String]): Unit = {
    // 常规while实现
    var n = 10
    while (n > 0) {
      println(n)
      n -= 1
    }

    println("========================")
    // 用函数实现while循环，用递归实现
    //下面为值调用，因此一直为true，所以会陷入死循环
//    def myWhile(condition: Boolean): ( => Unit) => Unit = {
    def myWhile(condition: => Boolean): ( => Unit) => Unit = {
      //定义一个内层循环函数，传入参数是一个代码块，代表当前循环执行的操作
      def loop(op: => Unit): Unit = {
        if (condition) {
          op
          myWhile(condition)(op)
        }
      }
      loop
    }
    n = 10
    myWhile (n > 0) {
      println(n)
      n -= 1
    }

    // 匿名函数简写
    def myWhile2(condition: => Boolean): ( => Unit) => Unit = {
      //定义一个内层循环函数，传入参数是一个代码块，代表当前循环执行的操作
      op=> {if (condition) {
          op
          myWhile2(condition)(op)
        }
      }
    }

    println("========================")
    n = 10
    myWhile2 (n > 0) {
      println(n)
      n -= 1
    }

    //柯里化简写
    def myWhile3(condition: => Boolean)(op: =>Unit) :Unit = {
     if (condition) {
        op
        myWhile3(condition)(op)
      }
    }

  }

}
