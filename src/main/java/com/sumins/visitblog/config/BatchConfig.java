package com.sumins.visitblog.config;

import com.sumins.visitblog.utils.SeleniumUtil;
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

    private final SeleniumUtil seleniumUtil;
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job blogPushJob() {
        return jobBuilderFactory.get("blogPushJob")
                .start(visitBlog())
                .build();
    }

    @Bean
    public Step visitBlog() {
        return stepBuilderFactory.get("visitBlog")
                .tasklet((contribution, chunkContext) -> {
                        seleniumUtil.visitBlog();
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}
