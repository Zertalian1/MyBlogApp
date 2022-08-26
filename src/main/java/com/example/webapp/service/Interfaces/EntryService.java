package com.example.webapp.service.Interfaces;

import com.example.webapp.model.Entry;

import java.util.List;

public interface EntryService {
    void addEntry(Entry entry);
    List<Entry> getAllEntries();
    Entry getEntryById(int id);
    void updateEntry(Entry newEntry, int id);
    void deleteEntryById(int id);
}
