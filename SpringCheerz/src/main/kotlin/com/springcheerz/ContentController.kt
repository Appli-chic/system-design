package com.springcheerz

import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ContentController {

    @PutMapping("/content")
    fun updateContent(): String {
        return "Le content est update !"
    }
}
