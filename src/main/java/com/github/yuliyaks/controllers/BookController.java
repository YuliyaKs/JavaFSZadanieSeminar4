package com.github.yuliyaks.controllers;

import com.github.yuliyaks.model.Book;
import com.github.yuliyaks.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /** Вывести на экран домашнюю страницу
     *
     * @return Домашняя страница
     */
    @GetMapping
    public String homePage(){
        return "home";
    }

    /** Вывести на экран список книг
     *
     * @param model Модель
     * @return Список книг
     */
    @GetMapping("/books")
    public String findAll(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book-list";
    }

    /** Вывести форму для создания книги
     *
     * @param book Книга
     * @return Форма для создания книги
     */
    @GetMapping("/book-create")
    public String createBookForm(Book book){
        return "book-create";
    }

    /** Создать новую книгу
     *
     * @param book Книга
     * @return Обновленный список книг
     */
    @PostMapping("/book-create")
    public String createBook(Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }

    /** Удалить книгу из списка
     *
     * @param id ID
     * @return Обновленный список книг
     */
    @GetMapping("/book-delete/{id}")
    public String deleteById(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    /** Вывести форму для обновления информации о книге
     *
     * @param id ID
     * @param model Модель
     * @return Форма для обновления информации о книге
     */
    @GetMapping("/book-update/{id}")
    public String updateBookForm(@PathVariable("id") Integer id, Model model) {
        List<Book> books = new ArrayList<>(bookService.findAll());
        Book book = null;
        for (Book bk : books) {
            if (bk.getId() == id) {
                book = bk;
            }
        }
        model.addAttribute("book", book);
        return "book-update";
    }

    /** Обновить информацию о книге
     *
     * @param book Книга
     * @return Обновленный список книг
     */
    @PostMapping("/book-update")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookService.updateBook(book);
        return "redirect:/books";
    }

    /** Вывести информацию о книге
     *
     * @param id ID
     * @param model Model
     * @return Информация о книге
     */
    @GetMapping("books/{id}")
    public String getBook(@PathVariable("id") Integer id, Model model){
        List<Book> books = new ArrayList<>(bookService.findAll());
        Book book = null;
        for (Book bk : books) {
            if (bk.getId() == id) {
                book = bk;
            }
        }
        model.addAttribute("book", book);
        return "book-profile";
    }

}
