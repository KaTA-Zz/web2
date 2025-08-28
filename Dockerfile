# Dùng image Tomcat chính thức
FROM tomcat:9.0-jdk17-temurin

# Xóa default app ROOT
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy code webapp (giả sử bạn build ra file .war)
COPY web/ /usr/local/tomcat/webapps/ROOT/

# Expose port 8080
EXPOSE 8080

# Chạy Tomcat
CMD ["catalina.sh", "run"]
