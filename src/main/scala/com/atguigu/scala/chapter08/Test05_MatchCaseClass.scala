package com.atguigu.scala.chapter08

/**
 * @author chenhuiup
 * @create 2020-09-20 14:33
 */
object Test05_MatchCaseClass {
  def main(args: Array[String]): Unit = {
    val student1 = new Student05("alice", 18)
    val student2 = new Student05("alice", 19)
    val student3 = new Student05("bob", 18)

    val list = List[Student05](student1,student2,student3)
    for (elem <- list){
      val result = elem match {
        case Student05("alice", 18) => "Yes, this is alice 18"
        case _ => "No"
      }
      println(result)
    }
  }

}

case class Student05(name:String,age:Int)
