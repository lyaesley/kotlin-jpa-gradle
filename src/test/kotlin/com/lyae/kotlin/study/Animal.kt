package com.lyae.kotlin.study

//#코틀린에서 클래스 상속과 인터페이스 구현은 콜론(:) 뒤에 상속할 클래스나 구현할 인터페이스를 작성
//*자바에서는 클래스 상속 extends , 클래스 구현 implements 를 사용한다.

//#상속
//코틀린의 클래스는 기본적으로 상속 불가다. 상속을 허용하려면 class 앞에 open 을 붙인다.
open class Animal {
    //open class 내의 함수도 오버라이딩을 허용하려면 fun 앞에 open 을 붙인다.
    open fun eat() {
        println("음식을 먹습니다")
    }
}

//#코틀린에서 클래스 상속과 인터페이스 구현은 콜론(:) 뒤에 상속할 클래스나 구현할 인터페이스를 작성
class Tiger : Animal() { //클래스를 구현할경우 () 생성자를 작성, 인터페이스는 생성자가 없기때문에 ()를 작성하지 않는다.
    //오버라이드시 fun 앞에 override 를 붙인다. *JAVA 는 @Override 어노테이션으로 표시
    override fun eat() {
        println("고기를 먹습니다")
    }

}

//#추상화 추상화 클래스
abstract class Robot {
    abstract fun eat()
    fun sniff() {
        println("킁킁")
    }
}

//#코틀린에서 클래스 상속과 인터페이스 구현은 콜론(:) 뒤에 상속할 클래스나 구현할 인터페이스를 작성
//클래스를 구현할경우 () 생성자를 작성, 인터페이스는 생성자가 없기때문에 ()를 작성하지 않는다.
class Tgv : Robot() {
    override fun eat() {
        println("휘발유를 마신다")
    }

}

/**
 * #추상화 인터페이스
 * 코틀린에서 인터페이스는 속성, 추상함수, 일반함수(body {} 구현함수) 를 가질수 있다.
 * *JAVA 의 인터페이스는 속성, 추상함수만 가질수 있고 '일반함수는 가질수 없다'
 * 생성자를 가질수 없다.
 * 구현부가 있는 함수 -> open 함수로 간주
 * 구현부가 없는 함수 -> abstract 함수로 간주
 */

interface Runner {
    fun run()

}

interface Eater {
    fun eat() {
        println("음식을 먹습니다")
    }
}

//#코틀린에서 클래스 상속과 인터페이스 구현은 콜론(:) 뒤에 상속할 클래스나 구현할 인터페이스를 작성
//여러개의 interface 를 구현할경우 콤마(,)로 여러개 기술
//클래스를 구현할경우 () 생성자를 작성, 인터페이스는 생성자가 없기때문에 ()를 작성하지 않는다.
class Dog : Runner, Eater {
    override fun run() {
        println("달린다")
    }

    override fun eat() {
        println("먹는다")
    }
}

fun main() {

    val t = Tiger()
    t.eat()

    val tgv = Tgv()
    tgv.sniff()
    tgv.eat()

    val dog = Dog()
    dog.run()
    dog.eat()
}
