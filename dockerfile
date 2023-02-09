FROM eclipse-temurin:17
WORKDIR /app
COPY target/gemtries-0.0.1-SNAPSHOT.jar .

ENV DB_USERNAME=postgres
ENV DB_PASSWORD=postgres

#ENTRYPOINT [ "java", "-cp", "gemtries-0.0.1-SNAPSHOT.jar", "com.huoji.gemtries.GemtriesApplication" ]
ENTRYPOINT ["java","-jar","/app/gemtries-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080