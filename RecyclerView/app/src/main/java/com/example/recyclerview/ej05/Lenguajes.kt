package com.example.recyclerview.ej05

import android.net.Uri

class Lenguajes private constructor(val nombre: String, val uriImagen: Uri) {
    constructor(nombre: String, urlImagenString: String) : this(nombre, Uri.parse(urlImagenString))
}


fun getData() = mutableListOf(
    Lenguajes("Java", "https://ubiqum.com/assets/uploads/2019/10/screenshot-2021-02-11-at-115416.png"),
    Lenguajes("Kotlin", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Kotlin_Icon.svg/2048px-Kotlin_Icon.svg.png"),
    Lenguajes("JavaScript", "https://i.pinimg.com/originals/12/49/49/1249492264f909cc540ddc8e87419e42.png"),
    Lenguajes("HMTL", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/HTML5_logo_and_wordmark.svg/1200px-HTML5_logo_and_wordmark.svg.png"),
    Lenguajes("Python", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Python-logo-notext.svg/1200px-Python-logo-notext.svg.png"),
    Lenguajes("PHP", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/PHP-logo.svg/1280px-PHP-logo.svg.png"),
    Lenguajes("C#", "https://seeklogo.com/images/C/c-sharp-c-logo-02F17714BA-seeklogo.com.png"),
    Lenguajes("Go", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Go_Logo_Blue.svg/1200px-Go_Logo_Blue.svg.png"),
    Lenguajes("Rust", "Esto va a fallar al convertir a URL")
)
