package com.atguigu.scala.chapter01

import java.io.{File, PrintWriter}

import javafx.print.Printer

import scala.io.Source

/**
 * @author chenhuiup
 * @create 2020-09-12 10:04
 */
object Test03_FileIO {
  def main(args: Array[String]): Unit = {
    //1.从文件读取数据
//    Source.fromFile("src/main/resources/test.txt").foreach(print)

    //2.写入文件
    val writer = new PrintWriter(new File("src/main/resources/out.txt"))
    writer.write("hello scala")
    writer.close()
  }

}
