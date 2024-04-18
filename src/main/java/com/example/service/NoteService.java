package com.example.service;

import com.example.note.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class NoteService {

    public List<Note> noteList;

    public NoteService() {
        noteList = new ArrayList<>();
    }

    public List<Note> listAll() {
        return noteList;
    }

    public Note add(Note note) {

        note.setId(new Random().nextInt());
        note.setTitle("some title");
        note.setContent("some content");
        noteList.add(note);

        return note;
    }

    public void deleteById(long id) {

        Note noteById = getById(id);
        noteList.remove(noteById);

    }

    public void update(Note note) {

        Note noteById = getById(note.getId());
        noteById.setTitle("new title");
        noteById.setContent("new content");

    }

    public Note getById(long id) {
        boolean checkIfContains = false;

        for (Note note : noteList) {
            if (note.getId() == id) {
                return note;
            }
        }
        if (!checkIfContains) {
            throw new NoSuchElementException("no such note with id " + id);
        }
        return null;
    }

}
