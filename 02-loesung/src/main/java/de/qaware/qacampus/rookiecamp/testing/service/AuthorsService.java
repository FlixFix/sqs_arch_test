package de.qaware.qacampus.rookiecamp.testing.service;

import de.qaware.qacampus.rookiecamp.testing.annotations.Service;
import de.qaware.qacampus.rookiecamp.testing.persistence.AuthorDao;

@Service
public class AuthorsService {
    AuthorDao authorDao;
}