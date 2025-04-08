# 第一階段：建置 Spring Boot 應用程式
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# 複製 pom.xml 和 src 目錄
COPY . .

# 使用 Maven 編譯並打包成 JAR
RUN mvn clean package -DskipTests

# 第二階段：運行 Spring Boot 應用程式
FROM eclipse-temurin:21-jdk
WORKDIR /app

ARG PORT=8080
ENV PORT=${PORT}

# 從 build 階段複製 jar 文件到 /app/app.jar
COPY --from=build /app/target/Fluxeip-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080
CMD ["sh", "-c", "java -jar /app/app.jar --server.port=${PORT}"]