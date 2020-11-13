package com.atguigu.scala.chapter07

/**
 * @author chenhuiup
 * @create 2020-09-18 9:39
 */

/*
注：
1. Array.ofDim[Int](2, 3) 的类型为Array[Array[Int]]，本质还是一维数组，Dim代表维度
2. println("hello"(1)) //String类中隐式转换后（indexseq）的apply方法，但是没有update方法
3. 不可变数组声明后，没有赋值，会有默认值
4. 最多能创建五维数组，遍历时每个维度对应一个foreach
5. arr.indices返回索引的Range集合
 */
object Test03_MulArray {
  def main(args: Array[String]): Unit = {

    // 1. 创建一个二维数组
    val arr: Array[Array[Int]] = Array.ofDim[Int](2, 3)

    // 2. 访问数组中元素，进行读写
    // 读取元素
    println(arr(0)(1)) //0
    // 为元素赋值
    arr(0)(2) = 27
    println(arr(0)(2)) //27
    arr(1)(1) = 27

    // 3. 对数组进行遍历
    // 3.1 对索引遍历
    for (i <- 0 until arr.length; j <- 0 until arr(i).length) {
      print(arr(i)(j) + "\t")
      if (j == arr(i).length - 1) println()
    }

    for (i <- arr.indices; j <- arr(i).indices) {
      print(arr(i)(j) + "\t")
      if (j == arr(i).length - 1) println()
    }
    println("================================")
    // 3.2 使用foreach()
    arr.foreach(elem => {
      elem.foreach(elem => print(elem + "\t"))
      println()
    })

    arr.foreach(_.foreach(println))

    println("================================")

    // 练习：创建一个五维数组，2*3*4*5*6，（0,2,1,3,4）元素值为100，遍历数组
    val test5 = Array.ofDim[Int](2, 3, 4, 5, 6)
    test5(0)(2)(1)(3)(4) = 100
    for (a <- test5; b <- a; c <- b; d <- c; f <- d) {
      print(f)
    }

    test5.foreach(elem => elem.foreach(elem => elem.foreach(elem => elem.foreach(elem => elem.foreach(print)))))
    println()
    test5.foreach(_.foreach(_.foreach(_.foreach(_.foreach(println)))))

    println("================================")

    println("hello"(1)) //String类中隐式转换后（indexseq）的apply方法
//    "hello"(0) = "w"  //error ，String中没有update方法
  }
}
