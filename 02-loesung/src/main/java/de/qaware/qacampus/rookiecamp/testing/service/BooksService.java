package de.qaware.qacampus.rookiecamp.testing.service;

import de.qaware.qacampus.rookiecamp.testing.annotations.Service;
import de.qaware.qacampus.rookiecamp.testing.persistence.BookDao;

@Service
public class BooksService {
    private BookDao bookDao;
}