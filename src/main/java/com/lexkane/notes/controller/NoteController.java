package com.lexkane.notes.controller;

import com.lexkane.notes.model.Note;
import com.lexkane.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String getNotes(Model model) {
        model.addAttribute("notes", noteService.getNotes());
        return "notes";
    }

    @RequestMapping(value = "/create_note", method = RequestMethod.POST)
    public String createNote(@RequestBody Note note, Model model) {
        noteService.createNote(note.getTitle(), note.getNote(), 1l);
        return this.getNotes(model);
    }

    @RequestMapping(value = "/create_note", method = RequestMethod.GET)
    public String create() {
        return "create_note";
    }

    @RequestMapping(value = "/note/view", method = RequestMethod.GET)
    public String getByID() {
        return "create_note";
    }

    @GetMapping("/notes/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("notes", noteService.findById(new Long(id)));
        return "show";
    }

    @GetMapping("/notes/delete/{id}")
    public String deleteById(@PathVariable String id, Model model) {
        noteService.deleteById(new Long(id));
        return this.getNotes(model);
    }

    @GetMapping("/notes/edit/{id}")
    public String update(@PathVariable String id, Model model) {
        model.addAttribute("notes", noteService.findById(new Long(id)));
        return "edit_note";
    }

    @PostMapping("/notes/edit/{id}")
    public String updateById(@PathVariable String id, @ModelAttribute("noteForEdit") Note note, Model model) {
        noteService.updateById(note.getTitle(), note.getNote(), new Long(id));
        return this.getNotes(model);
    }
}
