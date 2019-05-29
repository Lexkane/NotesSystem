package com.lexkane.notes.dao;

import com.lexkane.notes.model.Note;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

    List<Note> getByUserCode(Long userCode);



    @Modifying
    @Query(value = "insert into note ( title, note, user_code) values (:title, :note, :user_code);",
            nativeQuery = true)
    @Transactional
    void insertNote(@Param("title") String title,
                    @Param("note") String note, @Param("user_code") Long user_code);

    @Modifying
    @Query(value = "UPDATE note SET title = :title, note = :note  WHERE id = :id", nativeQuery = true)
    @Transactional
    void update(@Param("title") String title, @Param("note") String note, @Param("id") Long id);

}
