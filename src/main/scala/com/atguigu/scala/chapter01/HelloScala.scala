package com.atguigu.scala.chapter01

/**
 * @author chenhuiup
 * @create 2020-09-12 8:13
 */
/* object 对象名称
   -- 声明了一个单例对象（伴生对象），省略public,如果public写上会报错
 */
object HelloScala {
  /*
  def 函数名（参数名：参数类型）：返回值类型 = {函数体}
  -- scala 中没有static关键字，全部用伴生对象来调用
  -- scala中不用void表示空返回值，空返回值也是一个类型的对象，这个类叫做Unit
  -- 参数类型Array[String] 在scala中[]表示泛型
  -- 声明参数、变量或函数的时候，名称在前，类型在后，之间用冒号分割
  -- 每行代码结束不需要分号
   */
  def main(args :Array[String]):Unit = {
    println("hello,scala")
    System.out.println("hello,scala")
  }

}
