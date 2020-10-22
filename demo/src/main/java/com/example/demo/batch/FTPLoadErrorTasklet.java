package com.example.demo.batch;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public class FTPLoadErrorTasklet  implements Tasklet, InitializingBean {
	private static final Logger log = LoggerFactory.getLogger(FTPLoadErrorTasklet.class);
    private Resource source;
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.error("Trato el error en FTP");
        return RepeatStatus.FINISHED;
    }
    public void setDirectoryResource(Resource directory) { this.source = directory; }
    public void afterPropertiesSet() throws Exception { Assert.notNull(source, "directory must be set"); }
}

