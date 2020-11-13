package com.atguigu.scala.chapter06

/**
 * 1. 类体中的代码，就是主构造器中的代码
 * 2. 辅助构造器只能调用前面（代码顺序）的构造器
 * 3. 辅助构造器参数可以赋值，但是不能省略参数类型
 * 4. 函数参数的默认类型是val
 * 5. 类名相同的方法只是一般方法，因为构造器没有返回值
 * 6. 只有主构造器可以给参数加上val/var修饰，赋值构造器不能加
 * 7. 主构造器中的属性，在idea中显示为P，一般的属性显示为V
 * 8. 在辅助构造器中也能添加局部变量(但是不能赋值，否则报错，不知道为什么？)，是val类型的,因此对外是不可见的，只在构造器中有效
 * 9. 如果主构造器空参，辅助构造器有一个参数，且有默认值，如何选择有默认值的构造器？
 * 10. 主构造器中直接指定var类型，就定义了可变属性,scala推荐的方式，如果只有属性，
 * 没有方法可以省略类体{},相当于通过类管理多种不同类型的数据
 * 11. 在主构造器中定义属性，可以不给默认值，而在类体中定义属性必须给默认值。
 * 12. 主构造器属性没有加var/val，只是一个局部变量，对外不可见
 *
 * @author chenhuiup
 * @create 2020-09-15 22:47
 */
object Test05_Constructor {
  def main(args: Array[String]): Unit = {
    val student1 = new Student1()
    student1.Student1()
    println("===============")
    val student2 = new Student1("王五")
    println("================")
    val student3 = new Student1("bob", 25)
    println("================")
    val student4 = new Student1("bob", 25, "男")


  }
}

//创建类，主构造器无参
class Student1() {
  println("1.主构造器被调用")

  //定义属性
  var name: String = _
  var age: Int = _

  println(s"default student is $name $age")


  //声明辅助构造方法1
  def this(name: String = "张三") {
    this()
    println("2.辅助构造方法1")
    this.name = name
    println(s"student is $name $age")
  }

  //声明辅助构造方法2
  def this(name: String, age: Int) {
    this(name)
    println("3.辅助构造方法2")
    this.age = age
    println(s"student is $name $age")
  }

  //声明辅助构造方法3
  def this(name: String, age: Int, sex: String) {
    this(name)
    println("5.辅助构造方法3")
    this.age = age
    println(s"student is $name $age $sex")
  }

  //类名相同的方法只是一般方法
  def Student1(): Unit = {
    println("4.一般方法调用")
  }

}
