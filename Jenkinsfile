pipeline {
    agent { label 'jenkins-slave1' }
    stages {
        stage('maven build'){
            steps{
                sh 'mvn -DskipTests clean package'
                sh 'mv ${WORKSPACE}/target/*.war ${WORKSPACE}/target/hello-spring-boot-war-${BUILD_NUMBER}.war'
            }
        }
        }
    }
