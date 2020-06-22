package com.aj.playground.functions.functional.assignment

import io.kotlintest.shouldBe
import org.junit.Test
import java.io.File
import java.io.FileNotFoundException

class FileExtTest{
    @Test
    fun `check a new file is created with the passed text`(){
        val contentText = "This is a test content"
        val fileName = "test"
        File(fileName).w(contentText)
        File(fileName).readText() shouldBe contentText
        File(fileName).delete() shouldBe true
    }

    @Test(expected = FileNotFoundException::class)
    fun `check what happens if file name is empty`(){
        val contentText = "This is a test content"
        val fileName = ""
        File(fileName).w(contentText)

        File(fileName).readText() shouldBe contentText
        File(fileName).delete() shouldBe true
    }
}