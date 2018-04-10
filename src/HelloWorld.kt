/**
 * Created by lizheng on 2018/3/12.
 */

/**
 * 函数定义
 * public方法必须声明返回类型,其他不用
 */
public fun sum(a: Int, b: Int): Int = a + b;

/**
 * 可变参数方法声明
 */
fun vars(vararg v: Int) {
    for (vars in v) {
        print(vars)
    }
}

fun main(args: Array<String>) {

    println("Hello Kotlin World")

    println(sum(1, 1))

    vars(1, 2, 3, 4, 5, 6)

    /**
     * lambda匿名函数
     */
    val sumLambda: (Int, Int, Int) -> Int = { x, y, z -> x + y + z }
    println("   " + sumLambda(1, 2, 3))

    /**
     * 变量
     */
    var x = 5; // var为变量,系统自动推断类型

    /**
     * 常量
     */
    val y: Int = 6; // 这里可以声明类型,也可以自动推断
    val z: Int; // 无初值时必须提供类型

    /**
     * 字符串里可以直接用${}引用变量或函数
     */
    val str = "var x is $x"
    println(str)


    /**
     * 类似于java的instanceof（）
     */
    if (str is String) {
        println("str is String")
    }

    /**
     * ..表示区间
     */
    for (i in 7..10) print(i)

    println()
    // 使用 step 指定步长
    for (i in 7..10 step 2) print(i)
    println()
    // 倒序
    for (i in 10 downTo 7) print(i)
    println()
    // 排除最后一个
    for (i in 7 until 10) print(i)
    println()

    /**
     * 数字类型
     * 据说可以下划线分割,但是这里不知道为啥不行
     */
    val oneMillion = 1000000

    val creditCardNumber = 123567890123456L

    val socialSecurityNumber = 999999999L

    val hexBytes = 0xFFECDC5E

    val bytes = 0b11010010011010011001010010010010

    val t: Int = 10000
    //经过了装箱，创建了两个不同的对象
    val boxedT: Int? = t
    val anotherBoxedT: Int? = t

    //虽然经过了装箱，但是值是相等的，都是10000
    println(boxedT === anotherBoxedT) //  false，值相等，对象地址不一样
    println(boxedT == anotherBoxedT) // true，值相等

    /**
     * 数组类型
     */
    //[1,2,3]
    val a = arrayOf(1, 2, 3)
    //[0,2,4]
    val b = Array(3, { i -> (i * 2) })

    //读取数组内容
    println(a[0])    // 输出结果：1
    println(b[1])    // 输出结果：2

    /**
     * 字符串
     */
    val text1 = """
    多行字符串
    多行字符串
    """
    println(text1)   // 输出有一些前置空格

    val text2 = """
    |多行字符串
    |菜鸟教程
    |多行字符串
    |Runoob
    """.trimMargin()
    println(text2)    // 前置空格删除了

    /**
     * 条件控制
     */

    val max = if (x > y) x else y
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> {
            // 注意这个块
            println("x 不是 1 ，也不是 2")
        }
    }

    /**
     * 循环控制
     */
    val items = listOf("apple", "banana", "kiwi", "kiwi是奇异果");
    for (a in items) {
        println(a)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    /**
     * 类
     */
    var person: Person = Person("Mars");
    person.name = "李政"
    person.age = 24
    person.height = 183.1f
    print("name:${person.name}, age:${person.age},height:${person.height},home:${person.home}")
    person.age = 101;
    print(person.age)
    person.printPerson()
    var person2: Person = Person("earth", 66);
    print("name:${person2.name}, age:${person2.age},height:${person2.height},home:${person2.home}")

    /**
     * 继承
     * Kotlin 中所有类都继承该 Any 类，它是所有类的超类，对于没有超类型声明的类是默认超类
     * 但是Any并不是Object
     */
    var man: Man = Man("sun", "man");
    print("name:${man.name}, age:${man.age},height:${man.height},home:${man.home},sex:${man.sex}")
    man.printPerson();
    println(man.vehicle)
    man.takeOff()
    man.land()

    /**
     * 数据类,只包含数据
     */
    data class User(val name: String, val age: Int)

    val jack = User(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)
    println(jack)
    println(olderJack)

    /**
     * 密封类,枚举的扩展
     */
    sealed class Expr

    /**
     * 泛型
     */
    class Box<T>(t: T) {
        var value = t
    }

    var boxInt = Box<Int>(10)
    var boxString = Box<String>("Runoob")

    println(boxInt.value)
    println(boxString.value)

    /**
     * 枚举
     */
    var color: Color = Color.BLUE

    println(Color.values.forEach { value -> print("${value}_") })
    println(Color.valueOf("RED"))
    println(color.name)
    println(color.ordinal)

    /**
     * 对象声明 关键字:object
     * 通过声明对象来获得单例
     */
    var stick1 = Stick
    var stick2 = Stick
    stick1.length = 100
    println("stick2:length:${stick2.length}")

    /**
     * 伴生对象,类似类的静态对象
     * 伴生对象的成员看起来像其他语言的静态成员，但在运行时他们仍然是真实对象的实例成员
     */
    println("bastard:${Man.bastard}")

    /**
     * Kotlin 直接支持委托模式，更加优雅，简洁。Kotlin 通过关键字 by 实现委托
     * 这里只演示了类委托,后面还有别的委托,没怎么看懂
     */
    var littleMan = man
    Dog(littleMan).takeOff()


}

// ====================================父类======================================
open class Person(val home: String) { // 主构造器,如果一个类要被继承，可以使用 open 关键字进行修饰。

    var name: String = "默认名字"
        get() = field
        set

    var age: Int = 0
        get() = field
        set(age) {
            if (age < 0 || age > 100) {
                field = -1
            } else {
                field = age
            }
        }

    var height: Float = 0f

    // 初始化代码块
    init {
        println("初始化home:${home}")
    }

    // 次级构造函数,如果类有主构造函数，每个次构造函数都要，或直接或间接通过另一个次构造函数代理主构造函数。在同一个类中代理另一个构造函数使用this关键字
    constructor(home: String, age: Int) : this(home) {
        this.age = age
        println("age:${age}")
    }

    open fun printPerson() {
        println("调用了printPerson方法")
    }

}

// ==================================子类========================================
class Man(home: String, var sex: String) : Person(home), Fly {
    // 如果子类有主构造函数， 则基类必须在主构造函数中立即初始化。

    // 在基类中，使用fun声明函数时，此函数默认为final修饰，不能被子类重写。
    // 如果允许子类重写该函数，那么就要手动添加 open 修饰它, 子类重写方法使用 override 关键词
    override fun printPerson() {
        println("调用了子类printPerson方法")
    }

    override fun takeOff() {
        println("takkkkkkkkkkkkkkkkkkkkkkkkkingOff")
    }

    override var vehicle = "rocket"

    // 一个类里面只能声明一个内部关联对象，即关键字 companion 只能使用一次
    companion object {
        var bastard: String = "snow"
    }
}

// =================================接口=========================================
interface Fly {

    var vehicle: String // 熟悉必须是抽象的,由实现类实现
    // Kotlin 接口与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现
    fun takeOff()

    fun land() {
        println("lannnnnnnnnnnnding")
    }

}

// =================================委托类=========================================
class Dog(fly: Fly) : Fly by fly

// =================================枚举=========================================
enum class Color {
    RED, BLACK, BLUE, GREEN, WHITE

}

// =================================枚举=========================================
object Stick {
    var length: Int = 0
}

