package pl.edu.pwr.carrierrental;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.couchbase.repository.support.IndexManager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lukasz on 12/8/16.
 */
@EnableCouchbaseRepositories(basePackages = "pl.edu.pwr.carrierrental")
@Configuration
public class RepositoryConfig extends AbstractCouchbaseConfiguration{

    @Value("${spring.couchbase.bucket.name}")
    private String bucketName;
    @Value("${spring.couchbase.bucket.password}")
    private String password;
    @Value(value = "${spring.couchbase.bootstrap-hosts[0]}")
    private String hosts;


    @Override
    protected List<String> getBootstrapHosts() {
        return Arrays.asList(this.hosts);
    }

    @Override
    public IndexManager indexManager() {
        return new IndexManager(true, false, false);
    }

    @Override
    protected String getBucketName() {
        return this.bucketName;
    }

    @Override
    protected String getBucketPassword() {
        return this.password;
    }
}
