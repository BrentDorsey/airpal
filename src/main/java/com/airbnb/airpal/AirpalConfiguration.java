package com.airbnb.airpal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.secnod.dropwizard.shiro.ShiroConfiguration;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.airlift.units.DataSize;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayFactory;
import io.dropwizard.util.Duration;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.Setter;

import static io.airlift.units.DataSize.Unit.GIGABYTE;

public class AirpalConfiguration extends Configuration
{
    @Getter
    @Setter
    @JsonProperty
    private URI prestoCoordinator = null;

    @Getter
    @Setter
    @JsonProperty
    @NotNull
    private String prestoUser = "airpalChangeMe";

    @Getter
    @Setter
    @JsonProperty
    @NotNull
    private String prestoSource = "airpal";

    @Getter
    @Setter
    @JsonProperty
    @NotNull
    private String prestoCatalog = "hive";

    @Getter
    @Setter
    @JsonProperty
    @NotNull
    private String prestoSchema = "default";

    @Getter
    @Setter
    @JsonProperty
    @NotNull
    private boolean prestoDebug = false;

    @Getter
    @Setter
    @JsonProperty
    @NotNull
    private Duration usageWindow = Duration.hours(6);

    @Getter
    @Setter
    @JsonProperty
    private String s3SecretKey;

    @Getter
    @Setter
    @JsonProperty
    private String s3AccessKey;

    @Getter
    @Setter
    @JsonProperty
    private String s3Bucket;

    @Getter
    @Setter
    @JsonProperty
    private String s3EncryptionMaterialsProvider;

    @Getter
    @Setter
    @JsonProperty
    private String createTableDestinationSchema = "airpal";

    @Getter
    @Setter
    private DataSize bufferSize = DataSize.valueOf("512kB");

    @Getter
    @Setter
    @JsonProperty
    @NotNull
    private DataSize maxOutputSize = DataSize.valueOf("1GB");

    @Getter
    @Setter
    @Valid
    @JsonProperty
    @NotNull
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();

    @Getter
    @Setter
    @Valid
    @JsonProperty
    @NotNull
    private FlywayFactory flywayFactory = new FlywayFactory();

    @Getter
    @Setter
    @Valid
    @JsonProperty
    @NotNull
    private ShiroConfiguration shiro;

    @Getter
    @Setter
    @Valid
    @JsonProperty
    @NotNull
    private boolean useS3 = false;

    @Getter
    @Setter
    @Valid
    @JsonProperty
    @NotNull
    private boolean compressedOutput = false;

    @Getter
    @Setter
    @JsonProperty
    private String clientInfo = "airpal";

    @Getter
    @Setter
    @JsonProperty
    private io.airlift.units.Duration clientSessionTimeout = new io.airlift.units.Duration(1, TimeUnit.HOURS);

    @Getter
    @Setter
    @JsonProperty
    private Boolean optimizeHashGeneration = true;

    @Getter
    @Setter
    @JsonProperty
    private Boolean distributedJoin = true;

    @Getter
    @Setter
    @JsonProperty
    private Boolean distributedIndexJoin = false;

    @Getter
    @Setter
    @JsonProperty
    private Integer hashPartitionCount = 100;

    @Getter
    @Setter
    @JsonProperty
    private Boolean preferStreamingOperators = false;

    @Getter
    @Setter
    @JsonProperty
    private Integer taskWriterCount = 1;

    @Getter
    @Setter
    @JsonProperty
    private Integer taskConcurrency = 16;

    @Getter
    @Setter
    @JsonProperty
     private Boolean taskShareIndexLoading = false;

    @Getter
    @Setter
    @JsonProperty
    private DataSize maxQueryMemory = new DataSize(20, GIGABYTE);

    @Getter
    @Setter
    @JsonProperty
    private io.airlift.units.Duration queryMaxRunTime = new io.airlift.units.Duration(100, TimeUnit.DAYS);

    @Getter
    @Setter
    @JsonProperty
     private Boolean resourceOvercommit = false;

    @Getter
    @Setter
    @JsonProperty
    private io.airlift.units.Duration queryMaxCpuTime = new io.airlift.units.Duration(1_000_000_000, TimeUnit.DAYS);

    @Getter
    @Setter
    @JsonProperty
    private Boolean redistributeWrites = true;

    @Getter
    @Setter
    @JsonProperty
    private Boolean pushTableWriteThroughUnion = true;

    @Getter
    @Setter
    @JsonProperty
    private String executionPolicy = "all-at-once";

    @Getter
    @Setter
    @JsonProperty
    private String processingOptimization = "disabled";

    @Getter
    @Setter
    @JsonProperty
    private Boolean dictionaryAggregation = false;

    @Getter
    @Setter
    @JsonProperty
    private Boolean planWithTableNodePartitioning = true;

    @Getter
    @Setter
    @JsonProperty
    private Boolean colocatedJoin = false;

    @Getter
    @Setter
    @JsonProperty
    private Boolean reorderJoins = false;

    @Getter
    @Setter
    @JsonProperty
    private Integer initialSplitsPerNode = null;

    @Getter
    @Setter
    @JsonProperty
    private io.airlift.units.Duration splitConcurrencyAdjustmentInterval = new io.airlift.units.Duration(100, TimeUnit.MILLISECONDS);

    @Getter
    @Setter
    @JsonProperty
    private Boolean optimizeMetadataQueries = false;

    @Getter
    @Setter
    @JsonProperty
    private Integer queryPriority = 1;

    @Getter
    @Setter
    @JsonProperty
    private Boolean spillEnabled = false;

    @Getter
    @Setter
    @JsonProperty
    private DataSize operatorMemoryLimitBeforeSpill = new DataSize(4, DataSize.Unit.MEGABYTE);

    @Getter
    @Setter
    @JsonProperty
    private Boolean optimizeMixedDistinctAggregations = false;

    @Getter
    @Setter
    @JsonProperty
    private Boolean legacyOrderBy = false;

    @Getter
    @Setter
    @JsonProperty
    private Boolean reorderWindows = false;

    @Getter
    @Setter
    @JsonProperty
    private Boolean iterativeOptimizerEnabled = false;

    @Getter
    @Setter
    @JsonProperty
    private Boolean exchangeCompression = false;
}
