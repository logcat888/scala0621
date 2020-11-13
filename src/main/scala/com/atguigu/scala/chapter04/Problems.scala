package com.atguigu.scala.chapter04

/**
 * @author chenhuiup
 * @create 2020-09-12 15:41
 */
object Problems {
  def main(args: Array[String]): Unit = {
    //1.九九乘法表
    for (i <- 1 to 9; j <- 1 to i) {
      print(s"$i * $j = ${i * j} \t")
      if (i == j) println()
    }

    //2.九层妖塔
    for (i <- 1 to 9; j = " "; k = "*")
      println(s"${j * (9 - i)}${k * (i * 2 - 1)}")

    for {i <- 1 to 9
         j = " "
         k = "*"
         } {
      println(s"${j * (9 - i)}${k * (i * 2 - 1)}")
    }

    // 1. 九九乘法表
    for( i <- 1 to 9 ){
      for( j <- 1 to i ){
        print(s"$j * $i = ${i * j} \t")
      }
      println()
    }
    for( i <- 1 to 9; j <- 1 to i ){
      print(s"$j * $i = ${i * j} \t")
      if( i == j ) println()
    }

    // 2. 九层妖塔
    //      *
    //     ***
    //    *****
    for( i <- 1 to 9 )
      println(" " * (9 - i) + "*" * (2 * i - 1) )

    for{
      i <- 1 to 9
      j = 9 - i
      k = 2 * i - 1
    }
      println( " " * j + "*" * k )

    for{
      j <- 8 to 0 by -1
      k = 17 - 2 * j
    }
      println( " " * j + "*" * k )

    for{
      k <- 1 to 17 by 2
      j = (17 - k) / 2
    }
      println( " " * j + "*" * k )
  }

}
