FROM tomcat:alpine

ADD ROOT /usr/local/tomcat/webapps/ROOT
ADD catalina.sh /usr/local/tomcat/bin
ADD dubbo.properties.template /usr/local/tomcat/webapps/ROOT/WEB-INF/dubbo.properties

RUN chmod u+x /usr/local/tomcat/bin/catalina.sh
