FROM openjdk:8-jdk-oracle
ENTRYPOINT ["java","-jar","/backend/groot-blog-service.jar"]