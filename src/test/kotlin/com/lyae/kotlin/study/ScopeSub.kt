import com.lyae.kotlin.study.Animal

//스코프의 같은 레벨에서는 같은 이름의 멤버를 만들어서는 안된다
// Scope.kt 의 패지키멤버 a 가 있기 때문에 같은 이름의 멤버를 선언할 수 없다.
// 충돌설명:Conflicting declarations: public val a: String, public val a: String
// val a = "ScopeSub.kt 의 패키지 스코프"
// a = "ScopeSub.kt 의 패키지 스코프" 이렇게 재정의도 불가

fun main() {
    println(a) //Scope.kt 의 변수 내용 출력
    B().print() //같은 패키지에 선언된 클래스는 import 없이 사용 가능
    Animal().eat() //다른 패키지에 선언된 클래스를 사용하려면 import 를 사용하거나 패키지풀네임을 사용한다.
    com.lyae.kotlin.study.Tgv().eat() //패키지풀네임 사용
}

