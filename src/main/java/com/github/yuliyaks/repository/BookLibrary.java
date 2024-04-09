package com.github.yuliyaks.repository;

import com.github.yuliyaks.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookLibrary {
    private  final JdbcTemplate jdbc;

    public BookLibrary(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /** Найти все книги в библиотеке
     *
     * @return Список всех книг
     */
    public List<Book> findAll() {
        String sql = "SELECT * FROM bookTable";

        RowMapper<Book> bookRowMapper = (r, i) -> {
            Book rowObject = new Book();
            rowObject.setId(r.getInt("id"));
            rowObject.setTitle(r.getString("title"));
            rowObject.setAuthor(r.getString("author"));
            return rowObject;
        };
        return jdbc.query(sql, bookRowMapper);
    }

    /** Сохранить книгу в библиотеку
     *
     * @param book Книга
     * @return Книга
     */
    public Book save(Book book) {
        String sql = "INSERT INTO bookTable (title, author) VALUES (?, ?)";
        jdbc.update(sql,book.getTitle(), book.getAuthor());
        return  book;
    }

    /** Удалить книгу по ID
     *
     * @param id ID
     */
    public void deleteById(int id) {
        String sql ="DELETE FROM bookTable WHERE id=?";
        jdbc.update(sql, id);
    }

    /** Обновить информацию о книге
     *
     * @param book Книга
     */
    public void update(Book book){
        String sql = "UPDATE bookTable SET title=?, author=? WHERE id=?";
        jdbc.update(sql, book.getTitle(), book.getAuthor(), book.getId());
    }

}
