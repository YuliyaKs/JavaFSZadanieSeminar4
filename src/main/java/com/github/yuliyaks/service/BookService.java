package com.github.yuliyaks.service;

import com.github.yuliyaks.model.Book;
import com.github.yuliyaks.repository.BookLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookLibrary bookLibrary;

    @Autowired
    public BookService(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    /** Поиск всех книг
     *
     * @return Список книг
     */
    public List<Book> findAll(){
        return bookLibrary.findAll();
    }

    /** Сохранение книги в библиотеку
     *
     * @param book Книга
     * @return Книга
     */
    public Book saveBook(Book book){
        return bookLibrary.save(book);
    }

    /** Удаление книги по ID
     *
     * @param id ID
     */
    public void deleteById(int id) {
        bookLibrary.deleteById(id);
    }

    /** Обновление информации о книге
     *
     * @param book Книга
     */
    public void updateBook(Book book){
        bookLibrary.update(book);
    }

}
