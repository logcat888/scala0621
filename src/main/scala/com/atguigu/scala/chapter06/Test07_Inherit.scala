package com.atguigu.scala.chapter06

/**
 *
 * 1. 如果父类主构造器有属性，子类继承父类时，没有在子类主构造器指定属性，那么子类创建出来的对象无法通过 . 的方式
 *   获得提醒，但是仍然可以使用继承过来的属性和方法，只是不提醒而已。
 * 2. 通过class Student7(name:String,age :Int) extends Person7(name,age) 或者
 *    class Student7(name:String,age :Int) extends Person7 继承的父类属性，子类的主构造器相当于给父类构造器赋值，
 *    子类的主构造参数，不再是局部变量。相当于重写父类的主构造器。
 *  3. 子类继承父类，重写父类方法时，必须加上override修饰符，否则报错
 *
 * @author chenhuiup
 * @create 2020-09-15 23:47
 */
object Test07_Inherit {
  def main(args: Array[String]): Unit = {
    val student1 = new Student71
    student1.name = "张安"
    student1.printInfo


    val student2 = new Student72("张三",18)
    println(student2.name)
  }

}

// 定义父类
class Person7(var name: String, var age: Int) {
  println("1. 父类的主构造器调用")

  var idCardNo: String = _

  def this(name: String, age: Int, idCardNo: String) {
    this(name, age)
    println("2. 父类的辅助构造器调用")
    this.idCardNo = idCardNo
  }

  def this() {
    this("张三", 18)
  }

  def printInfo(): Unit = {
    println(s"person7: $name $age $idCardNo")
  }
}

//定义子类
class Student71 extends Person7 {

}

//定义子类
class Student72(name:String,age :Int) extends Person7{

}

//定义子类
class Student7(name:String,age :Int) extends Person7(name,age){
  println("3. 子类的主构造器调用")

  var stdNo: String = _

  def this(name: String, age: Int, stdNo: String){
    this(name, age)
    println("4. 子类的辅助构造器调用")
    this.stdNo = stdNo
  }

  override def printInfo(): Unit = {
    println("student print info")
    super.printInfo()
    println(s"student7: $name $age $stdNo")
  }

  def study(): Unit ={
    println("student is studying")
  }
}