package org.zalando.catwatch.backend.repo;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zalando.catwatch.backend.CatWatchBackendApplication;
import org.zalando.catwatch.backend.model.Project;
import org.zalando.catwatch.backend.repo.builder.ProjectBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mibraun on 12/08/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CatWatchBackendApplication.class)
public class ProjectStatsTests {

    @Autowired
    private ProjectRepository projects;

    @Test
    public void basicStatisticsTest() {
        projects.deleteAll();

        Date now = new Date();

        List<String> language_list = new ArrayList<>();
        language_list.add("Java");
        language_list.add("Scala");

        new ProjectBuilder(projects)
                .name("project-1")
                .commitsCount(100)
                .snapshotDate(now)
                .languages(language_list)
                .save();

        new ProjectBuilder(projects)
                .name("project-2")
                .commitsCount(50)
                .snapshotDate(Date.from(now.toInstant().minusSeconds(120)))
                .languages(language_list)
                .save();


        Date startDate = Date.from(now.toInstant().minusSeconds(60));
        Date endDate = now;

        for (Project p: projects.findProjectsByDateRange(startDate, endDate)) {
            System.out.printf("Project %s, commit %d, id %d %n", p.getName(), p.getCommitsCount(), p.getId());
        }
    }

}
