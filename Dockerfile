FROM java:8
VOLUME /tmp
EXPOSE 9999
ADD /target/feedback-application-0.1.0.jar feedback-application.jar
ENTRYPOINT ["java","-jar","feedback-application.jar"]
