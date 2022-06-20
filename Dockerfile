FROM openjdk:8
EXPOSE 8080
ADD target/hood-filler.jar hood-filler.jar 
ENTRYPOINT ["java","-jar","/hood-filler.jar"]