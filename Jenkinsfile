pipeline {
    agent none
    stages {
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('local-sonar') {
                   sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install org.jacoco:jacoco-maven-plugin:report'
                   sh 'mvn sonar:sonar' 
                }
            }
        }
        stage('maven build'){
            steps{
                sh 'mvn -DskipTests clean package'
                sh 'mv ${WORKSPACE}/target/*.war ${WORKSPACE}/target/hello-spring-boot-war-${BUILD_NUMBER}.war'
            }
        }
        }
    }
