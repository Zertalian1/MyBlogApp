package com.example.webapp.dao;

import com.example.webapp.model.Entry;
import com.example.webapp.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class EntryDAO {

    public List<Entry> getAllEntry(){
        return (List<Entry>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Entry ").list();
    }

    public Entry getEntryById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Entry.class, id);
    }

    public void addNewEntry(Entry entry){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(entry);
        tx1.commit();
        session.close();

    }

    public void updateEntry(Entry entry){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(entry);
        tx1.commit();
        session.close();
    }

    public void deleteEntry(int id){
        Entry entry = getEntryById(id);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(entry);
        tx1.commit();
        session.close();
    }
}
