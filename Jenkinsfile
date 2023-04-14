pipeline {
    agent none
    stages {
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('local-sonar') {
                   bat 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install org.jacoco:jacoco-maven-plugin:report'
                   bat 'mvn sonar:sonar' 
                }
            }
        }
        stage('maven build'){
            steps{
                bat 'mvn -DskipTests clean package'
                bat 'mv ${WORKSPACE}/target/*.war ${WORKSPACE}/target/hello-spring-boot-war-${BUILD_NUMBER}.war'
            }
        }
        }
    }
