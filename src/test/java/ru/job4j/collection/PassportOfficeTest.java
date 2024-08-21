package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PassportOfficeTest {

    @Test
    public void whenAddDuplicatePassport() {
        PassportOffice office = new PassportOffice();
        Citizen citizen1 = new Citizen("1234", "pupkin");
        Citizen citizen2 = new Citizen("1234", "ivanov");
        office.add(citizen1);
        boolean result = office.add(citizen2);
        assertThat(result).isFalse();
    }

    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }
}