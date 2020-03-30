package com.lyae.kotlin.study

/**
 * 고차함수 (1급시민, 1급객체)
 * 다른 엔티티가 일반적으로 사용할 수 있는 모든 작업을 지원하는 엔티티
 * 1급 객체의 조건 : 변수에 담을수 있다. 인자로 전달할 수 있다. 반환값으로 전달할 수 있다.
 * *코틀린에서는 모든 함수를 고차함수로 사용 가능하다.
 */

fun main() {
    //함수 b를 호출할때 함수 a를 패러미터로 넘긴다
    //일반 함수를 고차 함수로 넘기려면 함수 이름 앞에 콜론 두개 ex) ::a 를 붙여준다.
    b(::a)
    b(c)
    b(d)
    b(e)
    var returnVal = f()
    println(returnVal)
    g("람다함수 g를 호출")
    b(g)
    println("eCal 람다 함수 실행 ${eCal(10,20)}")
}

fun a (str: String) {
    println("$str 함수 a")
}

//#함수의 형식을 표현하는법
//함수 a를 파라미터로 받아보자.
//(자료형, 자료형, 파라미터 갯수만큼..) -> 리턴타입
//코틀린의 반환형이 없을경우 Unit(값이 없다는 형식)을 사용
fun b (someFun: (String)->Unit) {
    someFun("b가 호출한")
}


//#함수를 람다식으로 표현하는 람다함수
//람다함수는 그 차제가 고차함수다. 익명함수의 하나의 형태로 이름없이 사용 및 실행이 가능하다.
//고차함수는 별도의 연산자(콜론 2개 ::)없이 변수에 담을 수 있다.
//val a: Int 일반적인 변수선언의 자료형 대신 함수의 형식을 써준다. (자료형) -> 반환타입  ex) (String) -> Unit(반환값이 없다.) , (String) -> String, (Int) -> Int ...
val c: (String) -> Unit = { str: String -> println("$str 람다함수 C") }
//함수의 형식에 자료형 (String) 이 기술되어 있어 자료형이 자동으로 추론되어 생략 가능 str: String = str
val d: (String) -> Unit = { str -> println("$str 람다함수 D") }
//람다함수도 변수에 할당할때 타입추로 기능을 이용하여 축약 가능
// 자료형을 기술하지 않음  ex) e: (String) -> Unit = e (중괄호 안에 파라미터 자료형을 기술 {str: String}
val e = { str: String -> println("$str 람다함수 E") }

val eCal = { x: Int, y: Int -> x * y }
val eCal2 = { x: Int, y: Int ->
    println("이렇게 여러줄 사용 가능")
    x * y
}

//#람다함수가 여러줄일 경우 마지막 구문이 결과값으로 리턴된다.
val cal: (Int, Int) -> Int = {a,b ->
    println(a)
    println(b)
    a+b  // 마지막 구문인 a+b 를 리턴한다.
}

//#파라미터가 없는 람다함수는 중괄호 {} 안에 실행할 구문만 작성한다.
val f: () -> String = {
    println("파라미터가 없는 람다함수")
    println("이렇게 여러줄 나열")
    "이 스트링 문자열이 리턴됨"
}

//#파라미터가 하나뿐이라면 파라미터 이름을 생략하고 it 사용
var g: (String) -> Unit = { /*str: -> 생략하고 it 키워드 사용*/ println("$it it 키워드 사용한 람다함수 G") }