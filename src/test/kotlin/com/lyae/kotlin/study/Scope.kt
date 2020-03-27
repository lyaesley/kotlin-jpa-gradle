//스코프 scope : 변수나, 함수, 클래스같은 멤버들을 서로 공유하여 사용할 수 있는 범위를 지정해 둔 단위
//스코프가 지정되는 범위 : 패키지 내부, 클래스 내부, 함수 내부
//스코프 외부에서는 스코프 내부의 멤버를 참조연산자로만 참조가 가능하다. //참조연산자 . Class().member 의 '.' (점,닷)

//하나의 패키지에서 다른 패키지 내의 멤버를 참조 할 때 import 를 사용하거나 직접 참조연산자를 사용한다.
//동일 스코프 내에서는 멤버를 공유할 수 있다.

//스코프의 같은 레벨에서는 같은 이름의 멤버를 만들어서는 안된다
/**
 * 접근제한자
 * 패키지 스코프
 * public(기본값)       어떤 패키지에서도 접근 가능
 * internal             같은 모듈 내에서만 접근 가능
 * private              같은 파일 내에서만 접근 가능
 * protected            사용하지 않음
 *
 * 클래스 스코프
 * public(기본값)       클래스 외부에서 늘 접근 가능
 * internal             사용하지 않음
 * private              클래스 내부에서만 접근 가능
 * protected            클래스 자신과 상속받은 클래스에서 접근 가능
 */



//package 를 선언하지 않으면 default 패키지로 선언
// default 패키지에 만든 모든 멤버들은 같은 패키지 스코프에 포함된다
var a = "Scope.kt의 패키지 스코프"

class B {
    // 하위스코프에서는 상위스코프의 멤버를 재정의 할 수 있다.
    val a = "Scope.kt의 클래스 스코프"
    fun print() {
        println(a)
    }
}

fun main() {
    // 하위스코프에서는 상위스코프의 멤버를 재정의 할 수 있다.
    val a = "Scope.kt의 함수 스코프"
    println(a)
    B().print()
}