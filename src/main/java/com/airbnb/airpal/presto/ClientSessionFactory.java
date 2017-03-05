package com.airbnb.airpal.presto;

import javax.inject.Provider;

import com.facebook.presto.client.ClientSession;
import com.google.common.collect.ImmutableMap;

import io.airlift.units.Duration;
import java.net.URI;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import static java.util.concurrent.TimeUnit.MINUTES;

import static com.google.common.base.MoreObjects.firstNonNull;

import static io.airlift.units.Duration.succinctDuration;

public class ClientSessionFactory
{
    private final boolean debug;
    private final String defaultSchema;
    private final String catalog;
    private final String source;
    private final String clientInfo;
    private final String user;
    private final Provider<URI> server;
    private final String timeZoneId;
    private final Locale locale;
    private final Map<String, String> properties;
    private final Map<String, String> preparedStatements;
    private final String transactionId;
    private final Duration clientSessionTimeout;

    public ClientSessionFactory(
        Provider<URI> server,
        String user,
        String source,
        String clientInfo,
        String catalog,
        String defaultSchema,
        boolean debug,
        Duration clientSessionTimeout
    )
    {
        this.server = server;
        this.user = user;
        this.source = source;
        this.clientInfo = clientInfo;
        this.catalog = catalog;
        this.defaultSchema = defaultSchema;
        this.debug = debug;
        this.timeZoneId = TimeZone.getTimeZone("UTC").getID();
        this.locale = Locale.getDefault();
        this.properties = ImmutableMap.<String, String>of();
        this.preparedStatements = ImmutableMap.<String, String>of();
        this.transactionId = null;
        this.clientSessionTimeout = firstNonNull(clientSessionTimeout, succinctDuration(1, MINUTES));
    }

    public ClientSessionFactory(
        Provider<URI> server,
        String user,
        String source,
        String clientInfo,
        String catalog,
        String defaultSchema,
        Map<String, String> properties,
        boolean debug,
        Duration clientSessionTimeout
    )
    {
        this.server = server;
        this.user = user;
        this.source = source;
        this.clientInfo = clientInfo;
        this.catalog = catalog;
        this.defaultSchema = defaultSchema;
        this.debug = debug;
        this.timeZoneId = TimeZone.getTimeZone("UTC").getID();
        this.locale = Locale.getDefault();
        this.properties = properties;
        this.preparedStatements = ImmutableMap.<String, String>of();
        this.transactionId = null; //UUID.randomUUID().toString();
        this.clientSessionTimeout = firstNonNull(clientSessionTimeout, succinctDuration(1, MINUTES));
    }

    public ClientSessionFactory(
        Provider<URI> server,
        String user,
        String source,
        String clientInfo,
        String catalog,
        String defaultSchema,
        Map<String, String> properties,
        Map<String, String> preparedStatements,
        boolean debug,
        Duration clientSessionTimeout
    )
    {
        this.server = server;
        this.user = user;
        this.source = source;
        this.clientInfo = clientInfo;
        this.catalog = catalog;
        this.defaultSchema = defaultSchema;
        this.debug = debug;
        this.timeZoneId = TimeZone.getTimeZone("UTC").getID();
        this.locale = Locale.getDefault();
        this.properties = properties;
        this.preparedStatements = preparedStatements;
        this.transactionId = null; //UUID.randomUUID().toString();
        this.clientSessionTimeout = firstNonNull(clientSessionTimeout, succinctDuration(1, MINUTES));
    }

    public ClientSessionFactory(
        Provider<URI> server,
        String user,
        String source,
        String clientInfo,
        String catalog,
        String defaultSchema,
        Map<String, String> properties,
        Map<String, String> preparedStatements,
        String transactionId,
        boolean debug,
        Duration clientSessionTimeout
    )
    {
        this.server = server;
        this.user = user;
        this.source = source;
        this.clientInfo = clientInfo;
        this.catalog = catalog;
        this.defaultSchema = defaultSchema;
        this.debug = debug;
        this.timeZoneId = TimeZone.getTimeZone("UTC").getID();
        this.locale = Locale.getDefault();
        this.properties = properties;
        this.preparedStatements = preparedStatements;
        this.transactionId = transactionId;
        this.clientSessionTimeout = firstNonNull(clientSessionTimeout, succinctDuration(1, MINUTES));
    }

    public ClientSession create(String user, String schema)
    {
        return new ClientSession(
                server.get(),
                user,
                source,
                clientInfo,
                catalog,
                schema,
                timeZoneId,
                locale,
                properties,
                preparedStatements,
                transactionId,
                debug,
                clientSessionTimeout
        );
    }

    public ClientSession create(String schema)
    {
        return new ClientSession(
                server.get(),
                user,
                source,
                clientInfo,
                catalog,
                schema,
                timeZoneId,
                locale,
                properties,
                preparedStatements,
                transactionId,
                debug,
                clientSessionTimeout
        );
    }

    public ClientSession create()
    {
        return new ClientSession(
                server.get(),
                user,
                source,
                clientInfo,
                catalog,
                defaultSchema,
                timeZoneId,
                locale,
                properties,
                preparedStatements,
                transactionId,
                debug,
                clientSessionTimeout
        );
    }
}
