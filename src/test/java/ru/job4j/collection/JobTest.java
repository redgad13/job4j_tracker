package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    void ascendingNamesComparing() {
        Job job1 = new Job("Repair", 1);
        Job job2 = new Job("Check", 2);
        Comparator<Job> ascendingName = new JobAscByName();
        int result = ascendingName.compare(job1, job2);
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void ascendingPriorityComparing() {
        Job job1 = new Job("Repair", 1);
        Job job2 = new Job("Check", 2);
        Comparator<Job> ascendingPriority = new JobAscByPriority();
        int result = ascendingPriority.compare(job1, job2);
        assertThat(result).isLessThan(0);
    }

    @Test
    void descendingNameComparing() {
        Job job1 = new Job("Repair", 1);
        Job job2 = new Job("Check", 2);
        Comparator<Job> descendingName = new JobDescByName();
        int result = descendingName.compare(job1, job2);
        assertThat(result).isLessThan(0);
    }

    @Test
    void descendingPriorityComparing() {
        Job job1 = new Job("Repair", 1);
        Job job2 = new Job("Check", 2);
        Comparator<Job> descendingPriority = new JobDescByPriority();
        int result = descendingPriority.compare(job1, job2);
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByPriorityAndName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobDescByName());
        Job job1 = new Job("Impl task", 1);
        Job job2 = new Job("Fix bug", 2);
        int rsl = cmpNamePriority.compare(job1, job2);
        assertThat(rsl).isLessThan(0);
    }

}