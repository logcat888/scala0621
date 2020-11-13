package com.atguigu.scala.chapter06

/**
 * 0. 伴生类和伴生对象的两个条件：1）同一个文件；2）同名
 * 1. 当私有化无参主构造器，可以省略();当辅助构造器调用无参主构造器时，this()可以省略()
 * 2. 主构造器私有化，辅助构造器没有私有化，可以通过辅助构造器创建对象
 * 3. 伴生类想使用伴生对象内的方法或属性，必须通过伴生对象.方法/属性
 * 4. 伴生对象可以定义与伴生类同名的属性/方法
 * 5. 伴生对象只能使用伴生类(构造器)，不能在伴生对象内使用伴生类的属性和方法
 * 6. 使用伴生对象的apply方法获取对象，即便apply无参也不能省略()，否则不能获取伴生类的对象,获取的是伴生对象,指向伴生对象
 * 7. 伴生对象是单例对象，两个变量指向同一伴生对象，那么地址值是一样的（废话）
 * 8. 伴生对象的类型与伴生类的类型不相等，伴生对象的类型为 伴生类.type，其实伴生对象在底层生成2个类，有一个类于伴生类相同
 * 9. 伴生对象的属性不是new出来的对象的属性
 * 10. 伴生对象可以使用私有构造方法，特别容易实现工厂模式获取对象。
 * 11. scala是函数式编程的体现之一，比如主构造更像是一个函数，可以定义属性，内部有可执行的代码。
 * 12. 伴生对象内的apply方法其实就是一个方法，返回值不一定是对象，也可以是其他东西，
 *
 * @author chenhuiup
 * @create 2020-09-16 19:27
 */
object Test11_CreateObject {
  def main(args: Array[String]): Unit = {
    // 1. 用new的方式创建对象
    //    val student1 = new Student11()
    //    student1.printInfo()
    //    val student2 = new Student11("alice", 18)
    //    student2.printInfo()

    // 2. 用伴生对象的方法创建对象
    // 2.1 自定义的获取对象方法
    val student = Student11.newStudent("赵丽颖", 18)
    student.printInfo()
    println(student.name)

    // 2.2 使用apply方法获取对象
    val student2 = Student11.apply("赵丽颖", 18)
    val student3 = Student11("赵丽颖", 18)

    // 2.3 下面只是变量指向伴生对象
    val student4 = Student11  // student4 的 类型为Student11.type
    student4.study
    val student5 = Student11  // student5 的 类型为Student11.type

    println(student5 == student4) //true
    println(student5.eq(student4)) //true

    //判断伴生对象的类型与伴生类对象的类型是否相等
    println(student5.isInstanceOf[Student11]) //false，idea提示是比较不相关的类型

    // 2.4 使用qpply方法获取对象
    val student6 = Student11()




    Student11.printInfo()
  }

}

// 定义类，构造方法私有化
class Student11 private() {
  var name: String = _
  private var age: Int = _

  private def this(name: String, age: Int) {
    this
    this.name = name
    this.age = age
  }

  def printInfo(): Unit = {
    //    study //报错
    Student11.study()
    println(s"student: $name $age ${Student11.school}")
  }

  private def eat(): Unit = println("我在吃饭")
}

object Student11 {
  var school: String = "atguigu"
  var name: String = "张三"

  def newStudent(): Student11 = new Student11()

  def newStudent(name: String, age: Int): Student11 = new Student11(name, age)

  def study(): Unit = println("student is studying " + name)

  def printInfo(): Unit = println("student is studying " + name)

  def apply(): Student11 = new Student11()

  def apply(name: String, age: Int): Student11 = new Student11(name, age)


}
