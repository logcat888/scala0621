package com.atguigu.scala.chapter04

/**
 * @author chenhuiup
 * @create 2020-09-14 19:09
 */
object Test03_WhileLoop {
  def main(args: Array[String]): Unit = {
    def main(args: Array[String]): Unit = {
      // 1.while
      var num = 10
      while(num > 0) {
        println(s"$num while")
        num -= 1
      }

      // 2. do while
      num = 10
      val b = do {
        println(s"$num while")
        num -= 1
      } while( num > 10 )
      println(b)
    }
  }
}
