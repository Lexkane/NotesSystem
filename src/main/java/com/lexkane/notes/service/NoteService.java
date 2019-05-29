package com.lexkane.notes.service;

import com.lexkane.notes.dao.NoteRepository;
import com.lexkane.notes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getNotes() {
        return noteRepository.getByUserCode(1L);
    }

    public void createNote(String title, String note, Long userCode) {
        noteRepository.insertNote(title, note, userCode);
    }

    public Note findById(Long l) {
        Optional<Note> note = noteRepository.findById(l);
        if (!note.isPresent()) {
            throw new RuntimeException("Note not found!");
        }
        return note.get();
    }

    public void deleteById(Long l) {
        noteRepository.deleteById(l);
    }

    public void updateById(String title, String note, Long l) {
        noteRepository.update(title, note, l);
    }
}
