package com.atguigu.scala.chapter08

/**
 * @author chenhuiup
 * @create 2020-09-20 14:14
 */
/*
1.匹配对象：需要实现伴生对象的unapply()方法，对象提取器，以便模式匹配时case 能调用伴生对象的unapply方法
2. apply()相当于工厂方法，传递过来零件，组装成对象
3. unapply()相当于拆包，解构对象，检查对象的每个零件，匹配对象；unapply()返回值为Option[(T1,T2..)]类型,
   泛型为元组类型。 Some((t1,t2)),Some只能包装一个元素，且为元组类型，元组的()可加也可不加，因为只有一个元素。
4. 样例类case class 就是为了减少模式匹配 匹配对象时，需要写大量的代码，而为模式匹配优化设计的，会自动生成伴生对象的各种方法。
5. 对于样例类，不推荐用new的方式创建对象，而是直接用伴生对象的apply()方法创建对象。
6. 样例类的主构造器参数列表，默认是val的，推荐用val，但是也可显式写成var，不过不推荐
 */
object Test04_MatchObject {
  def main(args: Array[String]): Unit = {
    val student1 = new Student("alice", 18)
    val student2 = new Student("alice", 19)
    val student3 = new Student("bob", 18)
    val list = List[Student](student1,student2,student3)
    for (elem <- list){
      val result = elem match {
        case Student("alice", 18) => "Yes, this is alice 18"
        case _ => "No"
      }
      println(result)
    }
    /*
    Yes, this is alice 18
    No
    No
     */
  }

}

//伴生类
class Student(val name:String,val age:Int)

//伴生对象
object Student{
  def apply(name: String, age: Int): Student = new Student(name, age)

  def unapply(student: Student): Option[(String, Int)] = {
    if (student == null)
      None
    else
      Some(student.name,student.age)
    //包装成元组
//      Some((student.name,student.age)) //ok
  }
}
