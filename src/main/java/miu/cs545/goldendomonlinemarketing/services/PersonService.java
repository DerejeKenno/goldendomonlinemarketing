package miu.cs545.goldendomonlinemarketing.services;

import miu.cs545.goldendomonlinemarketing.domain.Person;

public interface PersonService {
    Person getPersonByPersonUsername(String username);
}
