pipeline {
    agent { label 'jenkins-slave1' }
    stages {
        stage('maven build'){
            steps{
                sh 'mvn -DskipTests clean package'
                sh 'mv ${WORKSPACE}/target/*.war ${WORKSPACE}/target/hello-spring-boot-war-${BUILD_NUMBER}.war'
            }
        }
        stage('upload war to s3'){       
            steps{
                sh "aws s3 cp ${WORKSPACE}/target/hello-spring-boot-war-${BUILD_NUMBER}.war s3://sangeetha-jenkins-war"
            }
        }
        stage('deploy to tomcatserver1'){     
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-creds', path: '', url: 'http://13.234.122.188:8080/')], contextPath: null, war: '**/*.war'
            }
        }
        }
    }
