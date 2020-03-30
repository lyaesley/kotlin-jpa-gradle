package com.lyae.kotlinJpaGradle.controller

import org.apache.commons.text.StringEscapeUtils
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class TestController {

    @RequestMapping("/test")
    fun test(model : Model): String {
        model.addAttribute("title", "타이틀")
        model["body"] = "바디"

        return "test"
    }

    @RequestMapping(path = ["/getHtml"])
    fun getHtml(model: ModelAndView) : ModelAndView {
        var htmlTag = """<h1>"이건가"</h1>"""
        htmlTag = StringEscapeUtils.escapeHtml4(htmlTag)
        htmlTag = StringEscapeUtils.unescapeHtml4(htmlTag)
        model.addObject("contents", htmlTag)
        model.viewName="some"
        return model
    }
}