pipeline {
    agent { label 'jenkins-slave1' }
    stages {
        stage('maven build'){
            steps{
                sh 'mvn -DskipTests install package'
                sh 'mv ${WORKSPACE}/target/*.war ${WORKSPACE}/target/hello-spring-boot-war-${BUILD_NUMBER}.war'
            }
        }
        stage('deploy to tomcatserver1'){     
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-creds', path: '', url: 'http://13.127.155.240:8080/')], contextPath: null, war: '**/*.war'
            }
        }
        }
    }
