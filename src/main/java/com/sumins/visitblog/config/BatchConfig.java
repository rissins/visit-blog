package com.sumins.visitblog.config;

import com.sumins.visitblog.utils.Selenium;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final Selenium selenium;


    @Bean
    public Job blogJob() {
        return jobBuilderFactory.get("blogJob")
                .start(visitBlog())
                .build();
    }

    @Bean
    public Step visitBlog() {
        return stepBuilderFactory.get("visitBlog")
                .tasklet((contribution, chunkContext) -> {
                        selenium.visitBlog();
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}
