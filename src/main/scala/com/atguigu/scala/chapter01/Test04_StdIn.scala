package com.atguigu.scala.chapter01

import scala.io.StdIn

/**
 * @author chenhuiup
 * @create 2020-09-12 11:16
 */
object Test04_StdIn {
  def main(args: Array[String]): Unit = {
    //从键盘输入信息
    println("请输入你的大名：")
    val name = StdIn.readLine()

    println("请输入你的芳龄：")
    val age = StdIn.readInt()

    //使用插值字符串，如果不加{} 变量后一定要有空格
    println(s"欢迎$age 岁的$name 来到天上人间")
  }

}
