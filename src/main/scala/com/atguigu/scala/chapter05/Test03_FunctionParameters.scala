package com.atguigu.scala.chapter05

/**
 * 1. 可变参数通过WrappedArray进行包装，在java中可变参数是数组实现
 * 2. 参数默认值，不能省略类型
 * 3. 如果不使用带名参数，会按照顺序进行参数覆盖
 * 4. 使用带名参数后，就必须一路到底使用带名，因为使用了参数名所以参数的顺序无所谓
 * 5. 当参数列表只有可变参数时，调用函数不传入参数，输出为 List()
 * 5. 当参数列表既有可变参数，又有其他参数时，不传入可变参数的值，输出为WrappedArray()
 * @author chenhuiup
 * @create 2020-09-14 20:00
 */
object Test03_FunctionParameters {
  def main(args: Array[String]): Unit = {
    //（1）可变参数
    def f1(str:String*):Unit= {
      println(str)
    }

    f1("aaa","bbb","ccc") //WrappedArray(aaa, bbb, ccc)
    f1() //List()

    //（2）如果参数列表中存在多个参数，那么可变参数一般放置在最后
    def f2(str1:String,str2:String*)={
      println(s"str1: $str1 \t str2: $str2")
    }
    f2("aaa","bbb","ccc") //str1: aaa 	 str2: WrappedArray(bbb, ccc)
    f2("aaa") //str1: aaa 	 str2: WrappedArray()

    // (3)参数默认值，一般将有默认值的参数放置在参数列表的后面
    def f3( name: String = "DongLiang" ): Unit ={
      println(name)
    }
    f3("ShiLei")
    f3()

    //（4）带名参数
    def f4(name :String= "赵丽颖",sex:String,school:String="尚硅谷")={
      println(s"name: $name \t sex: $sex \t school: $school")
    }
    f4("男","陈钰琪") //name: 男 sex: 陈钰琪 school: 尚硅谷
    f4(sex = "女") //name: 赵丽颖 sex: 女 school: 尚硅谷

    f5()
  }

  def f5 (name:String = "赵丽颖")={
    println(name)
  }
}
