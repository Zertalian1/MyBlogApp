package com.example.webapp.service.Impl;

import com.example.webapp.exception.EntryNotFoundException;
import com.example.webapp.model.Entry;
import com.example.webapp.repository.EntryRepository;
import com.example.webapp.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryServiceImpl implements EntryService {
    EntryRepository entryRepository;

    @Autowired
    public EntryServiceImpl(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }


    @Override
    public void addEntry(Entry entry) {
        entryRepository.save(entry);
    }

    @Override
    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }

    @Override
    public Entry getEntryById(int id) {
        return entryRepository.findById(id).orElseThrow(()-> new EntryNotFoundException(id));
    }

    @Override
    public void updateEntry(Entry newEntry, int id) {
        entryRepository.findById(id).map(entry->{
            entry.setText(newEntry.getText());
            entry.setTitle(newEntry.getTitle());
            return entryRepository.save(entry);
        });
    }

    @Override
    public void deleteEntryById(int id) {
        entryRepository.deleteById(id);
    }
}
