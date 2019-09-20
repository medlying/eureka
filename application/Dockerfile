FROM nexus-registry.cn133.azure.net/baselibrary/openjdk:8-jdk-alpine

RUN mkdir -p /opt/app/bin /opt/app/logs
RUN apk add --update curl bash && rm -rf /var/cache/apk/*
ENV APP_HOME /opt/app
ENV APP_MAIN_CLASS com.simao.application.server.ApplicationServer

ADD scaffold/docker/run.sh /opt/app/bin/run.sh
ADD scaffold/docker/template.sh /opt/app/bin/template.sh
RUN chmod +x /opt/app/bin/*

ADD ./flyway /opt/app/flyway/
ADD scaffold/docker/config /opt/app/config/
ADD scaffold/build/libs/app-standalone.jar /opt/app/app.jar

ADD migration/src/main/resources/migration/mysql /opt/app/flyway/sql/
RUN mkdir /opt/app/flyway/conf/
RUN chown -R 1000:1000 /opt/
RUN ls -la /opt/app/

USER 1000

WORKDIR /opt/app

ENTRYPOINT ["/opt/app/bin/run.sh"]

