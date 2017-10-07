package com.talfinder.learning.javadwmongodb;

import com.talfinder.learning.javadwmongodb.api.WelcomeApi;
import com.talfinder.learning.javadwmongodb.api.impl.WelcomeApiImpl;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class JavaDwMongodbApplication extends Application<JavaDwMongodbConfiguration> {

    public static void main(final String[] args) throws Exception {
        new JavaDwMongodbApplication().run(args);
    }

    @Override
    public String getName() {
        return "JavaDwMongodb";
    }

    @Override
    public void initialize(final Bootstrap<JavaDwMongodbConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<JavaDwMongodbConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(JavaDwMongodbConfiguration javaDwMongodbConfiguration) {
                return javaDwMongodbConfiguration.getSwaggerBundleConfiguration();
            }
        });
    }

    @Override
    public void run(final JavaDwMongodbConfiguration configuration,
                    final Environment environment) {
        this.registerApi(configuration, environment);
    }

    private void registerApi(final JavaDwMongodbConfiguration configuration, final Environment environment) {
        final WelcomeApi welcomeApi = new WelcomeApiImpl(configuration.getTemplate());
        environment.jersey().register(welcomeApi);
    }

}
