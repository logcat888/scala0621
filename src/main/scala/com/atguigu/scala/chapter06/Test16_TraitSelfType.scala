package com.atguigu.scala.chapter06

/**
 * 1. 特征自身类型：就是将一个特质/类B定义为自身类型A，这样特质A就能使用B的所有内容，但是使用时必须一起使用
 * 2. 特征自身类型实现注入时，如果将一个类A注入到特质B中，在一个类C要实现这个特质时，需要写成
 *    class C extends A with B， A 和 B的顺序不能颠倒。 但是如果将特质 B 注入到 特质A中，他们的先后顺序无所谓。
 * 3.  _: User =>    _ 代表给当前特质起别名，_纯粹是一个占位符，写什么都可以，但是建议写成_，方便识别。 User代表要
 *    注入的类或特质， => 代表是一种过程。 注入后可以直接使用，就像是自己的东西，但是使用时必须一起使用。
 *
 * @author chenhuiup
 * @create 2020-09-16 22:35
 */
object Test16_TraitSelfType {
  def main(args: Array[String]): Unit = {

  }
}

class User(var name: String, var password: String){
  def method = println("好好学习，天天向上")
}

trait UserDao {
  // 将User类型定义为UserDao的自身类型
  _: User =>
  def insert():Unit = {
    method
    println(s"insert into db ${name} $password")
  }
}

//报错
//class RegisterUser(name: String, password: String) extends  UserDao  with User(name,password)  {
//}

class RegisterUser(name: String, password: String) extends User(name,password) with UserDao {
}



