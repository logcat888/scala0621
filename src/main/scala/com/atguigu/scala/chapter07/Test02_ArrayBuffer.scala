package com.atguigu.scala.chapter07

import scala.collection.mutable.ArrayBuffer

/**
 * 1. 创建ArrayBuffer时既没有初始化赋值，或者指定长度，直接取索引位置值会抛异常
 * 2. 当通过arr(i) = 13的方式为ArrayBuffer中元素赋值时，若i >= arr.size，会抛异常。
 * 3. size() 方法为ArrayBuffer数组内实际装的元素，length()方法为ArrayBuffer的长度
 * 4. 可变集合ArrayBuffer使用 :+ 的方式添加元素，相当于不可变集合添加元素的方式，不推荐，原数组不变，会产生一个新对象
 * 5. 推荐可变集合ArrayBuffer使用append方法添加元素，其返回值为Unit
 * 6. insert方法向指定索引位置添加多个元素
 * 7. += 在数组的后面添加元素，+=：在数组的前面添加元素, += 方法的返回值为当前对象
 * 8. 删除元素：remove(2)删除指定索引位置的元素，remove(0,3) 从指定索引位置开始，删除3个元素
 * 9. arr -= i 删除元素从左向右遍历数组arr删除第一个值为i的元素
 * 10. 增加另一个数组的所有元素,appendAll() 向后添加一个集合,prependAll() 向前添加一个集合
 * 11. ++=：向前添加一个集合,:边为调用者
 * 12. 可变数组和不可变数组的转换:toArray,toBuffer
 *
 * @author chenhuiup
 * @create 2020-09-17 10:23
 */
object Test02_ArrayBuffer {
  def main(args: Array[String]): Unit = {
    // 1. 创建一个可变数组
    // 1) new的方式
    val arr1: ArrayBuffer[Int] = new ArrayBuffer[Int](5)
    // 2)使用伴生对象的apply方法
    val arr2: ArrayBuffer[Int] = ArrayBuffer(2, 4, 6, 8, 10)
    println(arr1) //ArrayBuffer()
    println(arr2) //ArrayBuffer(2, 4, 6, 8, 10)

    // 2. 访问数组元素进行读写操作
    arr2(2) = 7
    println(arr2(1)) //4
    //    println(arr1(0)) // 数组角标越界，IndexOutOfBoundsException
    //    arr1(2) = 13 // 数组角标越界，IndexOutOfBoundsException
    //    println(arr1) // 数组角标越界，IndexOutOfBoundsException
    println(arr1.size) // 0
    println(arr2.length) // 5
    arr1.append(1)
    println(arr1) // ArrayBuffer(1)
    arr1(0) = 15
    println(arr1) //  ArrayBuffer(15)

    //3.向数组中添加元素
    // 1) :+ 的方式相当于不可变集合添加元素的方式，不推荐，原数组不变，产生一个新对象
    val newArr1 = arr1 :+ 16
    println(newArr1) //ArrayBuffer(15, 16)
    println(arr1) //ArrayBuffer(15)
    println(newArr1 == arr1) //false
    println(newArr1.eq(arr1)) //false

    // 2) append方法的返回值为Unit
    val newArr2 = arr1.append(17, 18)
    println(newArr2) // ()
    println(arr1) // ArrayBuffer(15, 17,18)

    // 3)insert方法向指定索引位置添加元素
    arr1.insert(1, 20, 21, 22)
    println(arr1) //ArrayBuffer(15, 20, 21, 22, 17, 18)

    //4)符号方法的调用
    // += 在数组的后面添加元素，+=：在数组的前面添加元素, += 方法的返回值为当前对象
    println(arr2) //ArrayBuffer(2, 4, 7, 8, 10)
    arr2 += 30 += 31 += 32
    println(arr2) //ArrayBuffer(2, 4, 7, 8, 10, 30, 31, 32)
    println("=============")
    println(38 +=: 37 +=: 37 +=: arr2) //ArrayBuffer(38, 37, 37,2, 4, 7, 8, 10, 30, 31, 32)
    println(arr2) //ArrayBuffer(38, 37,37, 2, 4, 7, 8, 10, 30, 31, 32)

    // 4. 删除元素
    val arr3 = ArrayBuffer(1, 1, 2, 2, 2, 3,3, 3, 4)
    // remove(2)删除指定索引位置的元素
    arr3.remove(2)
    println(arr3) // ArrayBuffer(1, 1, 2, 2, 3,3, 3, 4)
    // remove(0,3) 从指定索引位置开始，删除3个元素
    arr3.remove(0,3)
    println(arr3) // ArrayBuffer(2, 3, 3, 3, 4)

    // arr -= i 删除元素从左向右遍历删除第一个值为i的元素
    arr3 -= 3
    println(arr3) //ArrayBuffer(2, 3, 3, 4)

    //5. 增加另一个数组的所有元素
    // appendAll() 向后添加一个集合
    arr3.appendAll(Array(7,8,9))
    println(arr3) //ArrayBuffer(2, 3, 3, 4, 7, 8, 9)
    // prependAll() 向前添加一个集合
    arr3.prependAll(ArrayBuffer(-7,15))
    println(arr3) //ArrayBuffer(-7, 15, 2, 3, 3, 4, 7, 8, 9)

    // ++=：向前添加一个集合
    val arr4 = ArrayBuffer(1,2,3)
    val arr5 = ArrayBuffer(7,7,8)
    arr5 ++=: arr4
    println(arr4) // ArrayBuffer(7, 7, 8, 1, 2, 3)
    println(arr5) // ArrayBuffer(7, 7, 8)

    //6.可变数组和不可变数组的转换
    val newArr4 = arr4.toArray
    println(newArr4 mkString("[",",","]")) //[7,7,8,1,2,3]
    val newArr41 = newArr4.toBuffer
    println(newArr41) //ArrayBuffer(7, 7, 8, 1, 2, 3)
    println(newArr4) //[I@1a407d53
  }
}
