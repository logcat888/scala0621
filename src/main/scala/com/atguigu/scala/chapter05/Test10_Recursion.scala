package com.atguigu.scala.chapter05

import scala.annotation.tailrec

/**
 *
 *  1.尾递归：1）在递归返回时，就返回一次递归调用，每一次调用就把下一层的结果返回，外层函数不参与计算，等到内层函数的结果。
 *           2）正常的递归是内层函数不断的压栈，外层函数不能释放，当数据量大时可能导致栈溢出。
 *           3）尾递归就是假如最后一次返回时能够返回一次递归调用，不做任何的计算，每一次调用就把下一层的结果返回，
 *           能够做到最后外层函数的返回就是内层函数的返回，在这种情况下就可以做优化。
 *           4）不需要把外层函数的上下文、局部变量保存，就不需要一层层的压栈，而是直接覆盖函数调用的那个栈针，因为
 *           外层函数的返回就是内层函数的返回。
 *           5）递归不参与计算，要么返回状态，要么返回递归。
 *   2.尾递归如何实现？ 在递归函数内部定义一个状态函数，函数的参数列表要有一个参数保存递归结果的状态（这样外层函数就不用参与计算，
 *     去等待内层的结果），比如loop(res: Int, n: Int)，res就记录了之前递归的结果，n代表递归参数，loop(res * n, n - 1)
 *   3.在idea中递归实现左边是蚊香，尾递归实现是闭环。
 *   4.在scala中可以使用注解@tailrec检测递归是否实现尾递归，如果没有实现会报错。
 *   5.尾递归不会占用资源，直接覆盖栈针，不会出现栈溢出。
 *
 * @author chenhuiup
 * @create 2020-09-15 17:53
 */
object Test10_Recursion {
  def main(args: Array[String]): Unit = {
    //求阶乘
    println(factorial(5))
    println(recursion(5))
    println(tailRecursion(5))

  }


  //用循环实现
  def factorial(n: Int): Int = {
    var res = 1
    for (i <- 1 to n) {
      res *= i
    }
    res
  }

  //用递归实现
  def recursion(n: Int): Int = {
    if (n == 0) {
      1
    } else {
      n * recursion(n - 1)
    }
  }

  //用尾递归实现
  def tailRecursion(n: Int) = {
    @tailrec
    def loop(res: Int, n: Int): Int = {
      if (n == 0) res else loop(res * n, n - 1)
    }

    loop(1, n)
  }




}
