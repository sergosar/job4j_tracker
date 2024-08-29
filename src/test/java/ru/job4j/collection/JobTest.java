package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByDescNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByAscName() {
        int rls = new JobAscByName().compare(
                new Job("god job", 1),
                new Job("bad job", 2)
        );
        assertThat(rls).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByDescName() {
        int rls = new JobDescByName().compare(
                new Job("god job", 1),
                new Job("bad job", 2)
        );
        assertThat(rls).isLessThan(0);
    }

    @Test
    public void whenComparatorByAscPriority() {
        int rls = new JobAscByPriority().compare(
                new Job("god job", 1),
                new Job("bad job", 2)
        );
        assertThat(rls).isLessThan(0);
    }

    @Test
    public void whenComparatorByDescPriority() {
        int rls = new JobDescByPriority().compare(
                new Job("god job", 7),
                new Job("bad job", 5)
        );
        assertThat(rls).isLessThan(0);
    }

    @Test
    public void whenComparatorByAscNameAndAscPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByAscNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}