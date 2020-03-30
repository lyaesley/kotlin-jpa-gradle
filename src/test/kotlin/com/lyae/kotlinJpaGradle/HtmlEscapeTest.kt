package com.lyae.kotlinJpaGradle

import org.apache.commons.text.StringEscapeUtils

fun main() {
    val htmlTag = "<h1>이건가</h1>"
    println(StringEscapeUtils.escapeHtml4(htmlTag))

}
class HtmlEscapeTest {

}